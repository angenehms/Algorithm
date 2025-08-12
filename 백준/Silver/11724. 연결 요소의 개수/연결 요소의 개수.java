import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int node;
	static int line;
	
	static int[][] graph;
	static boolean[] visited;
	
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		
		graph = new int[node+1][node+1];
		
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to]++;
			graph[to][from]++;
		}
		
		visited = new boolean[node+1];
		for(int i=1; i<=node; i++) {
			if (!visited[i]) {
                dfs(i);
                cnt++;
            }
		}
		
		System.out.println(cnt);
		
	} // end of main
	
	static void dfs(int start) {
		visited[start] = true;
		for(int i=1; i<=node; i++) {
			if(!visited[i] && graph[start][i] > 0) {
				dfs(i);
			}
		}
		
	} // end of dfs
	
} // end of class
