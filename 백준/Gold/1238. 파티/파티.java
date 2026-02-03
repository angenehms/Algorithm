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
	static int X;
	
	static class Node implements Comparable<Node> {
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
		X = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프 그리기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 단방향
			graph[from].add(new Node(to, weight));
		}
		
		result = new int[N+1];
		
		for(int i=1; i<=N; i++) daijkstra(i);
		System.out.println(findMax(result));
		
		
	} // end of main
	
	static int findMax(int[] arr) {
		int max = 0;
		for(int i=1; i<=N; i++) {
			if(max < arr[i]) max = arr[i];
		}
		return max;
	} // end of findMax
	
	static void daijkstra(int start) {
		
		// 큐 초기화
		pq = new PriorityQueue<>();
		
		// COST 배열 초기화
		COST = new int[N+1];
		Arrays.fill(COST, Integer.MAX_VALUE);
		
		pq.add(new Node(start, 0));
		COST[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node curr = pq.poll();
			if(COST[curr.to] < curr.weight) continue;
			for(Node next : graph[curr.to]) {
				if(COST[next.to] > COST[curr.to] + next.weight) {
					COST[next.to] = COST[curr.to] + next.weight;
					pq.add(new Node(next.to, COST[next.to]));
				}
			}
			
		}
		
		// result 배열에 업데이트		
		if(start == X) { // 2에서 각자 집까지
			for(int i=1; i<=N; i++) {
				result[i] += COST[i];
			}
		} else { // 각자 집에서 2까지
			result[start] += COST[X];
		}
		
	} // end of daijkstra
	
} // end of class
