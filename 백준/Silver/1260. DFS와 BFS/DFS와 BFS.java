import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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
	
	static int node;
	static int line;
	static int start;
	
	static StringBuilder sb = new StringBuilder();
	
	static List<Integer>[] graph; 
	
	static boolean[] visited;
	static Deque<Integer> q;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
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
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			// 양방향
			graph[from].add(to);
			graph[to].add(from);
		}
		
		// 정렬하기 (graph는 배열이다)
		for(int i=0; i<node+1; i++) {
			Collections.sort(graph[i]);
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
			sb.append(start).append(" ");
			visited[start] = true;
			for(int next : graph[start]) {
				dfs(next);
			}
		}
		
	} // end of dfs
	
	static void bfs(int start) {
		
		q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			for(int next : graph[curr]) {
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
		
	} // end of bfs
	
} // end of class
