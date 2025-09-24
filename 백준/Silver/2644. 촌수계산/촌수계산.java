import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int num;
		int level;
		Node(int num, int level) {
			this.num = num;
			this.level = level;
		}
	} // end of node
	
	static int N;
	static int personA;
	static int personB;
	
	static int relationN;
	
	static int[][] graph;
	static boolean[] visited;
	
	static Deque<Node> q;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		personA = Integer.parseInt(st.nextToken());
		personB = Integer.parseInt(st.nextToken());
		
		relationN = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		for(int i=0; i<relationN; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to]++;
			graph[to][from]++;
		}
		
		visited = new boolean[N+1];
		q = new ArrayDeque<>();
		System.out.println(bfs(personA, personB));
		
	} // end of main
	
	static int bfs(int start, int target) {
		q.add(new Node(start, 0));
		visited[start] = true;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int currLevel = curr.level;
			if(curr.num == target) return curr.level;
			for(int i=0; i<=N; i++) {
				if(!visited[i] && graph[curr.num][i] > 0) {
					q.add(new Node(i, currLevel+1));
					visited[i] = true;
				}
			}
//			// 아래처럼 하면 안됨 -> add 되는 게 next 가 그냥 1 이런 수임 왜냐면 노드번호가 아니라 위에서 ++ 로 했기때문에 그냥 갯수개념임
//			for(int next : graph[curr.num]) {
//				if(!visited[next] && graph[curr.num][next] > 0) {
//					q.add(new Node(next, currLevel+1));
//					visited[next] = true;
//				}
//			}
		}
		return -1;
	} // end of bfs
	
} // end of class
