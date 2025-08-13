import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
	
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
	
	static int node;
	static int line;
	static int start;
	
	static List<Node>[] graph;
	
	static int[] cost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		// 모든 가중치 10 이하의 자연수
		node = Integer.parseInt(st.nextToken()); // V
		line = Integer.parseInt(st.nextToken()); // E
		start = Integer.parseInt(br.readLine()); // K
		
		// 그래프 초기화
		graph = new ArrayList[node+1];
		for(int i=0; i<=node; i++) {
			graph[i] = new ArrayList<>(); 
		}
		
		// 그래프 그리기
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to, weight)); // 단방향
		}
		
		
		cost = new int[node+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		dijkstra(start);
		for(int i=1; i<=node; i++) {
			if(cost[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(cost[i]+"\n");
			}
		}
		
		System.out.println(sb);
		
		
	} // end of main
	
	static void dijkstra(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		cost[start] = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(cost[curr.to] < curr.weight) continue; 
			for(Node next : graph[curr.to]) {
				if(cost[next.to] > next.weight + cost[curr.to]) {
					cost[next.to] = next.weight + cost[curr.to];
					pq.add(new Node(next.to, cost[next.to])); // 다음 갈곳 업데이트 -> Node ( next.to, 새로 갱신된 cost 값 )
				}
			}
		}
		
	} // end of dijkstra
	
	
} // end of class
