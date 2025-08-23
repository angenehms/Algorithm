import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] map; 
	static List<Integer>[] graph;
	static boolean[] visited;
	static int staticStart;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// graph 초기화
		graph = new ArrayList[N];
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		// graph 그리기
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					graph[r].add(c);
				}
			}
		}
//		
//		if(N == 1) {
//			System.out.println(1);
//			return;
//		}
		
		// 시작점 마다마다 dfs 돌기
		for(int i=0; i<N; i++) {
			staticStart = i;
			visited = new boolean[N];
			dfs(i);
		}
		
		printMap(map);
		System.out.println(sb);
	} // end of main
	
	static void dfs(int start) {
		for(int next : graph[start]) {
//			if(next == staticStart && !visited[staticStart]) {
//				visited[next] = true;
//				map[staticStart][next] = 1;
////				return; // 순환시 return
//			}
			
			if(!visited[next]) {
				visited[next] = true;
				map[start][next] = 1;
				map[staticStart][next] = 1;
				dfs(next);
//				visited[next] = false;
			}
		}
	} // end of dfs
	
	static void printMap(int[][] map) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sb.append(map[r][c]).append(" ");
			}
			sb.append("\n");
		}
	} // end of printMap
	
} // end of class
