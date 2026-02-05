import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	
	static class Node implements Comparable<Node >{
		int to;
		int weight;
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	} // end of Node
	
	static ArrayList<Node>[] graph;
	
	static PriorityQueue<Node> pq;
	static int[] COST;
	
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 1번 컴퓨터는 슈퍼컴퓨터
		
		// 그래프 초기화
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		// 그래프 그리기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 양방향
			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}
		
		COST = new int[N+1];
		Arrays.fill(COST, Integer.MAX_VALUE);
		
		result = new int[N+1];
		daijkstra(1);
		
		for(int i=2; i<N+1; i++) {
			sb.append(i).append(" ").append(result[i]).append("\n");
		}
		
		System.out.println(N-1);
		System.out.println(sb);
	} // end of main
	
	static void daijkstra(int start) {
		
		pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		COST[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node curr = pq.poll();
			if(COST[curr.to] < curr.weight) continue;
			
			for(int i=0; i<graph[curr.to].size(); i++) {
				
				Node next = graph[curr.to].get(i);
				
				if(COST[next.to] > COST[curr.to] + next.weight) {
					COST[next.to] = COST[curr.to] + next.weight;
					result[next.to] = curr.to;
					pq.add(new Node(next.to, COST[next.to]));
				} 
				
			}
	

		}
		
	} // end of daijkstra
	 
} // end of class
