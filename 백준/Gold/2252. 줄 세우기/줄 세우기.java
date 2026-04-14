import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int node;
	static int line;
	
	static List<Integer>[] graph;
	static int[] degree;
	
	static Deque<Integer> q;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		
		degree = new int[node+1];
		q = new ArrayDeque<>();
		
		graph = new ArrayList[node+1];
		for(int i =0; i<node+1; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			degree[to]++;
		}
		
		for(int i=1; i<node+1; i++) {
			if(degree[i] == 0) {
				q.add(i);
			}
		}
		
		topol();
		System.out.println(sb);
		
	} // end of main
	
	static void topol() {
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			for(int next : graph[curr]) {
				degree[next]--;
				if(degree[next] == 0) {
					q.add(next);
				}
			}
		}
		
	} // end of topol
	
} // end of class
