import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean[][] visited;
	static Deque<Node> q;
	static Deque<Node> silCheeseQ;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static int result = 0;
	
	static boolean isClear = false;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화 및 그리기
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(!isClear) {
			sil();
			checkAir();
			result++;
			clearCheck();
		}
		
		System.out.println(result);
		
		
	} // end of main 
	
	static void clearCheck() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				int temp = map[r][c];
				if(temp == -1) map[r][c] = 0;
				if(map[r][c] != 0) return;
			}
		}
		isClear = true;
		return;
	} // end of isClear
	
	static void checkAir() {
		
		while(!silCheeseQ.isEmpty()) {
			Node curr = silCheeseQ.poll();
			int tempAirCnt = 0;
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(map[nr][nc] == -1) tempAirCnt++;
			}
			
			if(tempAirCnt >= 2) {
				map[curr.r][curr.c] = 0; 
			}
		}
		
	} // end of checkAir
	
	static void sil() {
		
		visited = new boolean[N][M];
		q = new ArrayDeque<>();
		silCheeseQ = new ArrayDeque<>();
		q.add(new Node(0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(checker()) {
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 1) {
						map[curr.r][curr.c] = -1;
						silCheeseQ.add(new Node(nr, nc));
//						visited[nr][nc] = true;
					} else {
						q.add(new Node(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
		
	} // end of bfs
	
	static void print() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				System.out.print(map[r][c]+"       ");
			}
			System.out.println();
		}
	} // end of print
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	} // end of checker;
	
} // end of class 
