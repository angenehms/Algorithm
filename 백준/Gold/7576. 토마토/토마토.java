import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	// 보관 후 하루가 지나면, 
	// 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 
	// 익은 토마토의 영향을 받아 익게 된다. 
	
	// 정수 1은 익은 토마토
	// 정수 0은 익지 않은 토마토
	// 정수 -1은 토마토가 들어있지 않음
	
	// 토마토가 모두 익을 때까지의 최소 날짜 출력
	// 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력
	// 토마토가 모두 익지는 못하는 상황이면 -1을 출력
	
	static int M; // 상자의 가로칸 수 2~1000
	static int N; // 상자의 세로칸 수 2~1000
	
	static int[][] map;
	
	static class Node {
		int r;
		int c;
		int level;
		Node(int r, int c, int level) {
			this.r = r;
			this.c = c;
			this.level = level;
		}
	} // end of Node
	
	static Deque<Node> q;
	static boolean[][] visited;
	
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static int result;
	static int count; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		q = new ArrayDeque<>();
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) { // 1이면 큐에 넣기
					q.add(new Node(r,c,0));
					visited[r][c] = true;
				}
				map[r][c] = temp;
			}
		}
		
		// 한바퀴 돌면서 상황 점검(bfs 돌기전 모두 익은 토마토인지 점검)
		out : for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] != 1) break out;
				count++;
			}
		}
		
		if(count == N*M) {
			System.out.println(0);
			return;
		}
		
//		// 한바퀴 돌면서 상황 점검(답구하기)
//		for(int r=0; r<N; r++) {
//			System.out.println();
//			for(int c=0; c<M; c++) {
//				System.out.print(map[r][c]);
//			}
//		}
		
		bfs();
		
		// 한바퀴 돌면서 상황 점검(답구하기)
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) {
					System.out.println(-1);
					return;
				} 
			}
		}
		
		System.out.println(result);
		
	} // end of main
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			result = curr.level;
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(!visited[nr][nc] && map[nr][nc] == 0) {
					q.add(new Node(nr, nc, curr.level + 1));
					visited[nr][nc] = true;
					map[nr][nc] = 1;
				}
			}
		}
		
		
	} // end of bfs
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	} // end of checker
	
} // end of class
