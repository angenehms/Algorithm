

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int node;
	static int line;

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
	
	static List<Node>[] graph;
	static int[] COST;
	
	static PriorityQueue<Node> pq;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		node = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		
		// 그리프 초기화
		graph = new ArrayList[node+1];
		for(int i=0; i<node+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프 그리기
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 한방향
			graph[from].add(new Node(to, weight));
		}
		
		COST = new int[node+1];
		for(int i=1; i<node+1; i++) {
			pq = new PriorityQueue<>();
			Arrays.fill(COST, Integer.MAX_VALUE);
			daijkstra(i);
			for(int j=1; j<node+1; j++) {
				if(COST[j] == Integer.MAX_VALUE) {
					sb.append(0).append(" ");
				} else {
					sb.append(COST[j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	} // end of main
	
	static void daijkstra(int start) {
		pq.add(new Node(start, 0));
		COST[start] = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(COST[curr.to] > curr.weight) continue;
			for(Node next : graph[curr.to]) {
				if(COST[next.to] > COST[curr.to] + next.weight) {
					COST[next.to] = COST[curr.to] + next.weight;
					pq.add(new Node(next.to, COST[next.to]));
				}
			}
		}
	}
	
} // end of class
