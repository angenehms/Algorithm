import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int testCase;
	
	static int node;
	static int line;
	static int start;
	
	static class Node implements Comparable<Node> {
		int to;
		int weight;
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	} // end of Node
	
	static List<Node>[] graph;
	
	static PriorityQueue<Node> pq;
	static int[] COST;
	
	static StringBuilder sb = new StringBuilder();
	
	static int resultCnt;
	static int resultTime;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		testCase = Integer.parseInt(br.readLine());
		for(int t=0; t<testCase; t++) {
			
			// 입력값 받기
			st = new StringTokenizer(br.readLine());
			node = Integer.parseInt(st.nextToken());
			line = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			// 그래프 초기화
			graph = new ArrayList[node+1];
			for(int i=0; i<node+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			// 그래프 그리기
			for(int i=0; i<line; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph[b].add(new Node(a, weight));
			}
			
			pq = new PriorityQueue<>();
			COST = new int[node+1];
			Arrays.fill(COST, Integer.MAX_VALUE);
			daijkstra(start);

			resultCnt = 0;
			resultTime = 0;
			
			for(int i=0; i<node+1; i++) {
				if(COST[i] == Integer.MAX_VALUE) continue;
				resultCnt ++;
				if(resultTime < COST[i]) resultTime = COST[i];
			}

			sb.append(resultCnt + " " + resultTime + "\n");
			
		} // end of tc
		
		System.out.println(sb);
		
	} // end of main
	
	static void daijkstra(int start) {
		
		pq.add(new Node(start, 0));
		COST[start] = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(curr.weight > COST[curr.to]) continue;
			for(Node next : graph[curr.to]) {
				if(COST[next.to] > COST[curr.to] + next.weight) {
					COST[next.to] = COST[curr.to] + next.weight;
					pq.add(new Node(next.to, COST[next.to]));
				}
			}
		}
		
		
	} // end of daijkstra
	
} // end of class
