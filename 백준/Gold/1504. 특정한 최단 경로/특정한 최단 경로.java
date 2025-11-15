

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.plaf.InternalFrameUI;

public class Main {

	static int node;
	static int line;
	
	static List<Node>[] graph;
	static class Node implements Comparable<Node> {
		int to;
		int weight;
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(Node o) {
			return this.weight -o.weight;
		}
	} // end of Node
	
	static int v1;
	static int v2;
	
	static int[] COST;
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		graph = new ArrayList[node+1];
		for(int i =0; i<node+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프 그리기
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 양방향
			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int startToV1 = daijkstra(1, v1); // start -> v1
		int startToV2 = daijkstra(1, v2); // start -> v2
		int v1ToV2 = daijkstra(v1, v2); // v1 -> v2
		int v1ToEnd = daijkstra(v1, node); // v1 -> end
		int v2ToV1 = daijkstra(v2, v1); // v2 -> v1
		int v2ToEnd = daijkstra(v2, node); // v2 -> end
		
		
		int case1 = -1; // start -> v1 -> v2 -> end
		int case2 = -1; // start -> v2 -> v1 -> end
		
		if(startToV1 != -1 && v1ToV2 != -1 && v2ToEnd != -1) {
			case1 = startToV1 + v1ToV2 + v2ToEnd;
		} 
		
		if(startToV2 != -1 && v2ToV1 != -1 && v1ToEnd != -1) {
			case2 = startToV2 + v2ToV1 + v1ToEnd;
		}
		
		if(case1 >0 && case2 >0) {
			System.out.println(Math.min(case1, case2));
		} else if(case1 >0 && case2 <0) {
			System.out.println(case1);
		} else if (case2 >0 && case1 <0) {
			System.out.println(case2);
		} else {
			System.out.println(-1);
		}
		
		
	} // end of main
	
	static int daijkstra(int start, int end) {
		
		COST = new int[node+1];
		Arrays.fill(COST, Integer.MAX_VALUE);
		
		pq = new PriorityQueue<>();
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
		
		if(COST[end] == Integer.MAX_VALUE) return -1;
		return COST[end];
		
	} // end of daijkstra
	
} // end of class
