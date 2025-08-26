import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int r;
		int c;
		int level;
		int wall;
		Node(int r, int c, int level, int wall) {
			this.r = r;
			this.c = c;
			this.level = level;
			this.wall = wall;
		}
	} // end of Node
	
	static int N;
	static int M;
	static int K;
	static boolean[][] map;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static boolean[][][] visited;	
	static Deque<Node> q;

	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// map 초기화 및 map 그리기
		map = new boolean[N+1][M+1];
		for(int r =1; r<N+1; r++) {
			String str = br.readLine();
			for(int c=1; c<M+1; c++) {
				int temp = str.charAt(c-1) - '0';
				if(temp == 1) {
					map[r][c] = true;
				}
			}
		}
	
		visited = new boolean[N+1][M+1][K+1];
		q = new ArrayDeque<>();
		
		if(M==1 && N==1) {
			System.out.println(1);
			return;
		}
		
		bfs(new Node(1,1,1,0));
		System.out.println(answer);
		
	} // end of main
	
	static void bfs(Node start) {
		
		q.add(start);
		visited[start.r][start.c][0] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			answer = curr.level + 1;
			for(int i=0; i<4 ;i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue; // 범위 밖일 시 다음 순회
				if(isGoal()) { // 다음칸이 도착지면 
					return;
				}
				int wallCnt = curr.wall;
				if(map[nr][nc]) { // 다음 이동할 칸이 벽이라면
					if(wallCnt >= K) {
						continue;
					} else {
						if(visited[nr][nc][wallCnt+1]) continue;
						q.add(new Node(nr, nc, answer, wallCnt + 1));
						visited[nr][nc][wallCnt+1] = true;
					}
				} else { // 다음 이동할 칸이 벽이 아니라면
					if(visited[nr][nc][wallCnt]) continue;
					q.add(new Node(nr, nc, answer, wallCnt));
					visited[nr][nc][wallCnt] = true;
				}
			} // end of dr dc
		} // end of while
		answer = -1;
		
	} // end of bfs
	
	static boolean isGoal() {
		if(nr == N && nc == M) {
			return true;
		}
		return false;
 	} // end of isGoal
	
	static boolean checker() {
		return 1<=nr && nr<N+1 && 1<=nc && nc<M+1;
	} // end of checker
	
} // end of class
