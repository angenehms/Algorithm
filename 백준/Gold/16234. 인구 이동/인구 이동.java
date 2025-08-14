import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int L;
	static int R;
	
	static int[][] A;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static Deque<int[]> q;
	static int dayCnt;
	
	static int unionNum; // unionInfo 에서 구분할 숫자
	static int[][] unionInfo; // 해당 위치 국가의 연합넘버
	
	static boolean isClear; // 더이상 인구이동이 필요한지에 대한 여부 (bfs 돌면서 판단)
	
	static List<Integer> afterMoveList;
//	static int[] afterMoveList; 
	
	static int sameUnionNCnt; // 같은 연합 국가 갯수
	static int totalInSameUnion; // 같은 연합 국가들의 총 인구
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		// map 그리기
		A = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(!isClear) {
			unionNum = 0;
			unionInfo = new int[N][N]; // 연합 구분 초기화
			isClear = true; // true 로 초기화, bfs 시에 연합 나뉘면 false 로 변경할 예정
			afterMoveList = new ArrayList<>();
			afterMoveList.add(0);
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					q = new ArrayDeque<>();
					if(unionInfo[r][c] == 0) bfs(new int[] {r,c}); // 연합 나누기 bfs
				}
			}
			move();
			
			if(!isClear) dayCnt++;

//			dayCnt++;
		}
		
		System.out.println(dayCnt);
		
	} // end of main
	
	static void bfs(int[] start) { // 연합 나누기
		
		sameUnionNCnt = 0; // 초기화
		totalInSameUnion = 0; // 초기화
		
		q.add(start);
		unionNum++;
		unionInfo[start[0]][start[1]] = unionNum;
		
		sameUnionNCnt++;
		totalInSameUnion += A[start[0]][start[1]];
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int i=0; i<4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(!checker()) continue;
				if(unionInfo[nr][nc] == 0) { // 연합이 이루어지지 않은 곳이고
					int diff = Math.abs(A[curr[0]][curr[1]] - A[nr][nc]); // 두 지역의 인구 차이
					if(L <= diff && diff <= R) { // 원래의 곳과 지금 탐색하는 곳의 인구 차이가 L 이상 R 이하라면
						isClear = false;
						q.add(new int[] {nr, nc});
						unionInfo[nr][nc] = unionNum; // 같은 연합 취급
						
						sameUnionNCnt++;
						totalInSameUnion += A[nr][nc];
					}
				}
			}
		}
		
		afterMoveList.add(totalInSameUnion / sameUnionNCnt);
		
	} // end of bfs
	
	static void move() { // 계산된 값을 가지고 인구이동
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				A[r][c] = afterMoveList.get(unionInfo[r][c]);
			}
		}
	} // end of move
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc <N;
	} // end of checker
	
//	static boolean isAllSame() {
//		int temp = A[0][0]; 
//		for(int r=0; r<N; r++) {
//			for(int c=0; c<N; c++) {
//				if(A[r][c] == temp) return false;
//			}
//		}
//		return true;
//	} // end of isAllSame
	
} // end of class
