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
	
	// bfs
	static boolean[][] visited;
	static Deque<Node> q;
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1 ,1};
	static int nr;
	static int nc;
	
	static int max = 0;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 1) {
					cnt++;
					bfs(r,c);
				}
			}
		}
		
		sb.append(cnt).append("\n").append(max);
		System.out.println(sb);
		
	} // end of main
	
	static void bfs(int r, int c) {
		int temp = 0; // 이번 bfs 사이클에서 구해지는 섬의 넓이
		q = new ArrayDeque<>();
		q.add(new Node(r,c));
		map[r][c] = 2; // visited 효과
		temp++;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(!visited[nr][nc] && map[nr][nc] == 1) {
					q.add(new Node(nr,nc));
					map[nr][nc] = 2; // visited 효과
					temp++;
				}
			}
		}
		if(temp>max) max = temp;
	} // end of bfs
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	} // end of checker
	
} // end of class
