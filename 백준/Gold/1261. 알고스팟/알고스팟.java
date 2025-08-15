import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int weight;
		
		Node(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int N;
	static int M;
	static int[][] map;
	
	static int[][] cost;
	static PriorityQueue<Node> pq;
	
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1 ,1};
	
	static int nr;
	static int nc;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// map 그리기
		map = new int[N+1][M+1];
		for(int r=1; r<=N; r++) {
			String str = br.readLine();
			for(int c=1; c<=M; c++) { // 인덱스 편히 위해 만든 곳은 -1 로 채움
				map[r][c] = str.charAt(c-1) - '0'; // 여기도 1-based 하려면 주의해야함
			}
		}
		
		// 인덱스 편히 위해 만든 곳 말고, 
		// cost 2차원 배열 max 로 채우기
		cost = new int[N+1][M+1];
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=M; c++) {
				cost[r][c] = Integer.MAX_VALUE;
			}
		}
		
		pq = new PriorityQueue<>();
		dijkstra(1, 1);
		System.out.println(cost[N][M]);
		
	} // end of main
	
	static void dijkstra(int r, int c) {
		pq.add(new Node(r, c, 0));
		cost[r][c] = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(cost[curr.r][curr.c] < curr.weight) continue;
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker(nr, nc)) continue; 
				if(cost[nr][nc] > cost[curr.r][curr.c] + map[nr][nc]) {
					cost[nr][nc] = cost[curr.r][curr.c] + map[nr][nc];
					pq.add(new Node(nr, nc, cost[nr][nc]));
				}
			}
		}
	} // end of dijkstra
	
	static boolean checker(int r, int c) {
		return 1<=r && r<=N && 1<=c && c<=M;
	} // end of checker
	
} // end of class
