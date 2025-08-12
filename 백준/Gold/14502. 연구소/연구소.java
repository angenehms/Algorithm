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
	static int M;
	static int[][] map;
	static Deque<int[]> q = new ArrayDeque<>();
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	static int nr;
	static int nc;
	
	static List<int[]> empty = new ArrayList<>();
	
	static boolean[] visited;
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		//		 0은 빈 칸, 
		//		 1은 벽, 
		//		 2는 바이러스
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		// map 그리기와 바이러스 위치저장
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) {
					q.add(new int[] {r,c}); // 바이러스 위치 저장
				} else if(map[r][c] == 0) {
					empty.add(new int[] {r,c});
				}
			}
		}
		
		visited = new boolean[empty.size()];
		comb(0, 0);
		
		System.out.println(max);
		
	} // end of main
	
	static void comb(int start, int idx) {
		
		if(idx == 3) {
			int[][] copyMap = new int[N][M];
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					copyMap[r][c] = map[r][c];
				}
			}
			Deque<int[]> copyQ = new ArrayDeque<>();
			for(int[] virusPoint : q) {
				copyQ.add(new int[] {virusPoint[0], virusPoint[1]});
			}
			bfs(copyMap, copyQ);
			int temp = countSafe(copyMap);
			if(max < temp) max = temp;
			return;
		}
		
		for(int i=start; i<empty.size(); i++) {
			if(!visited[i]) {
				
				// 벽 세우기
				int r = empty.get(i)[0];
				int c = empty.get(i)[1];
				map[r][c] = 1;
				
				visited[i] = true;
				comb(i+1, idx+1);
				
				map[r][c] = 0;
				visited[i] = false;
			}
		}
		
	} // end of comb
	
	static void bfs(int[][] copyMap, Deque<int[]> copyQ) { // 바이러스 퍼트리기
		while(!copyQ.isEmpty()) {
			int[] curr = copyQ.poll();
			for(int i=0; i<4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(!checker()) continue;
				if(copyMap[nr][nc] == 0) { // 옮겨갈 곳이 빈칸이면
					copyQ.add(new int[] {nr, nc});
					copyMap[nr][nc] = 2;
				}
			}
		}
	} // end of bfs
	
	static int countSafe(int[][] copyMap) {
		int result = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(copyMap[r][c] == 0) result++;
			}
		}
		return result;
	} // end of countSafe
	
	static boolean checker() {
		return 0<= nr && nr < N && 0<= nc && nc <M;
	}
	
} // end of class
