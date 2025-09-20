import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	// 문제출처 : Main_백준_S2_1260_DFS와BFS

	// DFS로 탐색한 결과
	// BFS로 탐색한 결과
	
	// 방문할 수 있는 정점이 여러 개인 경우 -> 정점 번호가 작은 것을 먼저 방문
	// 더 이상 방문할 수 있는 점이 없는 경우 종료
	// 정점 번호는 1번부터 N번까지
	
	// 첫째줄 
	// 정점의 개수 N(1 ≤ N ≤ 1,000) - node 
	// 간선의 개수 M(1 ≤ M ≤ 10,000) - line
	// 탐색을 시작할 정점의 번호 - start

	// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어짐
	// 어떤 두 정점 사이에 여러개의 간선이 있을 수 있음
	// 입력으로 주어지는 간선은 양방향
	
	static class Node {
		
		int from;
		int to;
		int weight;
		
		Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	} // end of Node
	
	static int node;
	static int line;
	static int start;
	
	static boolean[] visited;
	static List<Node>[] graph;
	
	static StringBuilder sb = new StringBuilder();
	
	static Deque<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		// graph 초기화
		graph = new ArrayList[node+1];
		for(int i=1; i<=node; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// graph 그리기
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(from, to, 0));
			graph[to].add(new Node(to, from, 0));

		}
		
		// graph 정렬하기
		for(int i=0; i<=node; i++) {
			if(graph[i] == null) continue;
			graph[i].sort((a,b) -> a.to - b.to);
		}
		
		visited = new boolean[node+1];
		dfs(start);
		sb.append("\n");
		visited = new boolean[node+1];
		bfs(start);
		System.out.println(sb);
		
	} // end of main
	
	static void dfs(int start) {
		if(!visited[start]) {
			visited[start] = true;
			sb.append(start).append(" ");
			for(Node node : graph[start]) {
				if(!visited[node.to]) {
					dfs(node.to);
				}
			}
		}
	} // end of dfs
	
	static void bfs(int start) {
		q.add(start);
		visited[start] = true;
		sb.append(start).append(" ");
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(Node node : graph[curr]) {
				if(!visited[node.to]) {
					q.add(node.to);
					visited[node.to] = true;
					sb.append(node.to).append(" ");
				}
			}
		}
	} // end of bfs
	
} // end of class
