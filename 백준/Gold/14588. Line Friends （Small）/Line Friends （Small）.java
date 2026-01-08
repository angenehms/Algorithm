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
	static int Q;
	
	static class Line {
		int left;
		int right;
		Line(int left, int right) {
			this.left = left;
			this.right = right;
		}
	} // end of Line
	
	static class Node {
		int to;
		int level;
		Node(int to, int level) {
			this.to = to;
			this.level = level;
		} 
	} // end of Node -> 선분 번호를 Node 번호로 다루기 위함
	
	static Line[] lineInfo;
	static List<Node>[] graph;
	
	static Deque<Node> q;
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		// lineInfo 초기화
		lineInfo = new Line[N+1];

		// lineInfo 그리기 -> 인덱스넘버는 라인넘버
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			lineInfo[i] = new Line(left, right);
		}
		
		// 그래프 초기화
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프 그리기
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<N+1; j++) {
				Line former = lineInfo[i];
				Line latter = lineInfo[j];
				if(isFriend(former, latter)) {
					// 양방향 친구
					graph[i].add(new Node(j, 0));
					graph[j].add(new Node(i, 0));
				}
			}
		}
		
		Q = Integer.parseInt(br.readLine());
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			q = new ArrayDeque<>();
			visited = new boolean[N+1];
			bfs(start, target);
		}
		
		System.out.println(sb);
		
	} // end of main
	
	static void bfs(int start, int target) {
		
		q.add(new Node(start, 0));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int currTo = curr.to; // 3
			int currLevel = curr.level; // 0
			for(Node next : graph[currTo]) {
				if(visited[next.to]) continue; // 현재 노드에서 뻗어져 나가는 다음 노드를 이미 방문했다면
				if(next.to == target) {
					sb.append(currLevel+1).append("\n");
					return;
				}
				q.add(new Node(next.to, currLevel+1));
				visited[next.to] = true;
			}
		}
		
		sb.append(-1).append("\n");
		
	} // end of bfs
	
	static boolean isFriend(Line former, Line latter) {
		
		int formerLeft = former.left;
		int formerRight = former.right;
		int latterLeft = latter.left;
		int latterRight = latter.right;
		
		if(formerLeft <= latterLeft && formerRight >= latterLeft) return true;
		if(formerLeft <= latterRight && formerRight >= latterRight) return true;
		
		if(latterLeft <= formerLeft && latterRight >= formerLeft) return true;
		if(latterLeft <= formerRight && latterRight >= formerRight)	return true;
			
		return false;
		
	} // end of isFriend
	
} // end of class
