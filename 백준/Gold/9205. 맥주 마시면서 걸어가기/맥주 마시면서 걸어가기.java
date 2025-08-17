import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
 	} // end of Node
	
	static int T;
	static int storeCnt;
	static Node[] nodeList;
	static List<List<Integer>> graph;

	static Deque<Integer> q;
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			storeCnt = Integer.parseInt(br.readLine());
			nodeList = new Node[storeCnt + 2];
			// 집 노드 저장
			st = new StringTokenizer(br.readLine());
			int houseR = Integer.parseInt(st.nextToken());
			int houseC = Integer.parseInt(st.nextToken());
			nodeList[0] = new Node(houseR, houseC);
			
			// 편의점 노드 저장
			for(int i=0; i<storeCnt; i++) {
				st = new StringTokenizer(br.readLine());
				int storeR = Integer.parseInt(st.nextToken());
				int storeC = Integer.parseInt(st.nextToken());
				nodeList[i+1] = new Node(storeR, storeC);
			}
			
			// 목적지 노드 저장
			st = new StringTokenizer(br.readLine());
			int festivalR = Integer.parseInt(st.nextToken());
			int festivalC = Integer.parseInt(st.nextToken());
			nodeList[storeCnt + 1] = new Node(festivalR, festivalC);
			
			// 조합
			graph = new ArrayList<>();
			for(int i=0; i<storeCnt+2; i++) { // 초기화 이런거 잘하기
				graph.add(new ArrayList<>()); // 처음에 graph.add(0) 이따구로 썼다가 틀림
			}
			for(int i=0; i<storeCnt+1; i++) {
				for(int j=i+1; j<storeCnt+2; j++) {
					Node from = nodeList[i];
					Node to = nodeList[j];
					if(isPossible(from ,to)) { // 가능한 거리면
						// 무방향이기에
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			
			visited = new boolean[graph.size()];
			q = new ArrayDeque<>();
			bfs(0);
			
			
		} // end of tc
		
		System.out.println(sb);
		
	} // end of main
	
	static void bfs(int start) {
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr == graph.size()-1) {
				sb.append("happy").append("\n");
				return;
			}
			for(int next : graph.get(curr)) {
				if(visited[next]) continue; // 방문 했으면 다음 순회로
				visited[next] = true;
				q.add(next);
			}
		}
		sb.append("sad").append("\n");
		
	} // end of bfs
	
	static boolean isPossible(Node from, Node to) {
		int xGap = Math.abs(from.r - to.r);
		int yGap = Math.abs(from.c - to.c); // 이런거 r c 구분 잘하기 여기도 r 로 써서 틀렸었음
		int dist = xGap + yGap;
		if(dist>1000) { // 이거 계산 때문에 틀렸었음
			return false;
		} else {
			return true;
		}
	} // end of isPossible
	
} // end of class
