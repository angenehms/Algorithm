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
	static int[][] map;
	static int testCycle = 0;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static int[][] COST;
	
	static PriorityQueue<Node> pq;
			
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break; // N 이 0 나오면 while 종료
			testCycle++;
			
			// map 그리기
			map = new int[N][N];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// COST 초기화 후 Max 로 채우기
			COST = new int[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					COST[r][c] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra(0, 0, map[0][0]);
			
			sb.append("Problem")
			.append(" ")
			.append(testCycle)
			.append(":")
			.append(" ")
			.append(COST[N-1][N-1])
			.append("\n");
			
		}
		
		System.out.println(sb);
		
		
	} // end of main
	
	static void dijkstra(int r, int c,int weight) {
		
		pq = new PriorityQueue<>();
		pq.add(new Node(r,c,weight));
		COST[r][c] = weight;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(COST[curr.r][curr.c] < map[curr.r][curr.c]) continue; // 갈 필요 없으면 가지 않는다!
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(COST[nr][nc] > COST[curr.r][curr.c] + map[nr][nc]) {
					COST[nr][nc] = COST[curr.r][curr.c] + map[nr][nc];
					pq.add(new Node(nr, nc, COST[curr.r][curr.c] + map[nr][nc]));
				}
			}
		}
		
		
		
	} // end of dijkstra
	
	static boolean checker() {
		
		return 0<=nr && nr<N && 0<=nc && nc<N;
		
	} // end of checker
	
	static int getMin() {
		
		int min = Integer.MAX_VALUE;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(COST[r][c] < min) {
					min = COST[r][c];
				}
			}
		}
		return min;
		
	} // end of getMin
	
} // end of class
