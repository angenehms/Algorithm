import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static List<Integer>[] graph;
	static int[] degree;
	static Deque<Integer> q;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		degree = new int[N+1];
		
		// 그래프 초기화
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프 그리기 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			// 방향 그래프
			graph[from].add(to);
			degree[to]++;
		}
		
		q = new ArrayDeque<>();
		for(int i=1; i<N+1; i++) {
			if(degree[i] == 0) {
				q.add(i);
			}
		}
		
		topologicalSort();
		System.out.println(sb);
		
	} // end of main 
	
	static void topologicalSort() {
		
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
		
	} // end of topologicalSort
	
} // end of class
