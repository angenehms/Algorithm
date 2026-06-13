import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	
	static int N;
	
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
	
	public int solution(int n, int s, int a, int b, int[][] fares) {
		N = n;
		
		// 그래프 초기화
		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프 그리기
		for(int i=0; i<fares.length; i++) {
			int from = fares[i][0];
			int to = fares[i][1];
			int weight = fares[i][2];
			
			// 양방향
			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}
		
		// 각각 s, a, b에서 출발하는 최단 거리 배열 구하기
		int[] distS = daijkstra(s);
		int[] distA = daijkstra(a);
		int[] distB = daijkstra(b);
		
		int minCost = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			if(distS[i] != Integer.MAX_VALUE && distA[i] != Integer.MAX_VALUE && distB[i] != Integer.MAX_VALUE) {
				int total = distS[i] + distA[i] + distB[i];
				if(minCost > total) minCost = total;
			}
		}
		
		return minCost;
		
	} // end of main
	
	static int[] daijkstra(int start) {
		
		// 큐 초기화
		pq = new PriorityQueue<>();
		
		// COST 배열 초기화
		int[] COST = new int[N+1];
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
		
		return COST;
		
	} // end of daijkstra
	
} // end of class