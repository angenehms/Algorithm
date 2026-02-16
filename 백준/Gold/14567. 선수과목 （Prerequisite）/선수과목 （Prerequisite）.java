import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	
	static ArrayList<Integer>[] graph;
	static int[] degree;
	
	static Deque<Node> q;
	static class Node {
		int now;
		int level;
		Node(int now, int level) {
			this.now = now;
			this.level = level;
		}
	} // end of Node
	
	static int[] hak;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		degree = new int[N+1];
		q = new ArrayDeque<>();
		hak = new int[N+1];
		
		// 그래프 그리기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			degree[to]++;
		}
		
		for(int i=1; i<N+1; i++) {
			if(degree[i] == 0) q.add(new Node(i ,1)); // 1학기부터니까 1 삽입
		}
		
		topol();
		for(int i=1; i<N+1; i++) {
			sb.append(hak[i]).append(" ");
		}
		
		System.out.println(sb);
		
	} // end of main
	
	static void topol() {
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int currLevel = curr.level;
			hak[curr.now] = currLevel;
			for(int next : graph[curr.now]) {
				degree[next]--;
				if(degree[next] == 0) {
					q.add(new Node(next, currLevel+1));
				}
			}
		}
		
	} // end of topol
	
} // end of class
