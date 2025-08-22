import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int to;
		public Node(int to) {
			this.to = to;
		}
	} // end of Node
	
	static int N;
	static List<Node>[] graph;
	static boolean[] visited;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to));
			graph[to].add(new Node(from));
		}
		visited = new boolean[N+1];
		parents = new int[N+1];
		dfs(1);
		for(int i=2; i<=N; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
	} // end of main
	static void dfs(int start) {
		
			visited[start] = true;
			for(Node child : graph[start]) {
				if(!visited[child.to]) {
					dfs(child.to);
					parents[child.to] = start;
				}
			}
		
	} // end of dfs
} // end of class
