import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int node;
	static int line;
	
	static int cost;
	static int count;
	
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
	static PriorityQueue<Node> pq;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		node = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>();
		visited = new boolean[node+1];
		
		// 그래프 초기화
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
			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}
		
		prim(1);
		System.out.println(cost);
		
	} // end of main
	
	static void prim(int start) {
		pq.add(new Node(start,0));
//		visited[start] = true; // 여기 쓰면 안됨 왜냐면 bfs 랑 달리 이렇게 미리 방문처리 하면 안됨 -> 프림과 다익스트라의 경우 가중치가 다르기 때문에 pq 에 들어간 값이 최소라고 보장되지 않기 때문이다. 즉 나중에 더 싼 간선 및 경로가 나올 수 있기 때문이다. 
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visited[curr.to]) continue; // 방문했으면 넘어가기
			visited[curr.to] = true; // 이렇게 프림은 최소간선으로 선택된 순간에만 방문처리 해야함
			cost += curr.weight;
			count++;
			if(count == node) break;
			for(Node next : graph[curr.to]) {
				pq.add(next);
//				visited[next.to] = true; // 위에서 미리 방문처리(주석한 부분)를 했어서 여기다가도 방문처리를 한건데.. 프림과 다익스트라에서는 가중치가 다르기에 이러면 안됨 
			}
		}
	} // end of prim
	
} // end of class
