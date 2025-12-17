import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int testCase;
	static int node;
	static int line;
	
	static List<Integer>[] graph;
	static int[] nodeColor;
	static boolean isGood;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			
			st = new StringTokenizer(br.readLine());
			node = Integer.parseInt(st.nextToken());
			line = Integer.parseInt(st.nextToken());
			
			// 그래프 초기화
			graph = new ArrayList[node+1];
			for(int i=0; i<node+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			nodeColor = new int[node+1]; // 1 이면 파랑, -1 이면 빨강
			isGood = true;
			
			for(int i=0; i<line; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				graph[to].add(from);
			}
			
			for(int i=1; i<node+1; i++) {
				if(!isGood) break;
				if(nodeColor[i] == 0) {
					dfs(i, 1);
				}
			}
			
			sb.append(isGood ? "YES\n" : "NO\n");
			
		} // end of tc
		
		System.out.println(sb);
		
	} // end of main
	
	static void dfs(int start, int color) {
	
		nodeColor[start] = color; // start 파랑으로 칠하기
		for(int next : graph[start]) {
			
			if(nodeColor[next] == color) {
				isGood = false;
				return;
			}
			
			if(nodeColor[next] == 0) {
				dfs(next, -color);
			}
			
		}
	
		
	} // end of dfs
	
} // end of class
