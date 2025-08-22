import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		} // end of node
	}
	
	static int N;
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static Deque<Node> q;
	static boolean[][] visited;
	static int safeZoneCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// map 초기화 후 그리기
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int rain=0; rain<=100; rain++) {
			
			// 비 내리기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] <= rain) {
						map[r][c] = 0; // 잠기면 0 으로 변경
					}
				}
			}
			
			// 초기화
			visited = new boolean[N][N];
			safeZoneCnt = 0;
			
			// 안전지대 찾기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(visited[r][c]) continue;
					if(map[r][c] != 0) {
						bfs(new int[] {r,c});
						safeZoneCnt++;
					}
				}
			}
			
			if(max < safeZoneCnt) {
				max = safeZoneCnt;
			}
			
		} 
		
		System.out.println(max);
		
		
	} // end of main
	
	static void bfs(int[] start) {
		
		q = new ArrayDeque<>();
		
		q.add(new Node(start[0], start[1]));
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int i=0; i<4; i++ ) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(!visited[nr][nc] && map[nr][nc] != 0) { // 방문한 적 없고, 물에 안잠긴 곳
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
		
	} // end of bfs
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<N;
	} // end of checker
	
} // end of class
