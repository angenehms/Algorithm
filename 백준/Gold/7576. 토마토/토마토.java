import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
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
	
	// 상하좌우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int nr;
	static int nc;
	
	static int minDay;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// map 초기화 및 그리기
		map = new int[N][M];
		q = new ArrayDeque<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) q.add(new Node(r,c, 0));
				map[r][c] = temp;
			}
		}
		
		bfs();
		System.out.println(findResult());
		
	} // end of main
	
	static int findResult() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c]==0) return -1; 
			}
		}
		return minDay;
	} // end of findResult
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			minDay = curr.level;
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(map[nr][nc] == 0) {
					q.add(new Node(nr, nc, curr.level + 1));
					map[nr][nc] = 1;
				}
			}
		}
		
	} // end of bfs
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	}
	
} // end of class
