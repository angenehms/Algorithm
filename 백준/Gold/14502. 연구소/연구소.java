import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int result = 0;
	
	static int N;
	static int M;
	static int[][] map;
	
	static int[][] copyMap;
	
	// 상하좌우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int nr;
	static int nc;
	
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	} // end of Node
	
	static Deque<Node> q;
	static Deque<Node> copyQ;
	static List<Node> emptyZone;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		q = new ArrayDeque<>();
		copyQ = new ArrayDeque<>();
		emptyZone = new ArrayList<>();
		
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 2) q.add(new Node(r,c));
				if(temp == 0) emptyZone.add(new Node(r,c));
				map[r][c] = temp;
			}
		}
		
		visited = new boolean[emptyZone.size()];
		
//		copyMap = map; // 이렇게 하면 copyMap 변환 시 map 도 변함
		
		copyMap = new int[N][M];
		comb(0, 0);
		
		System.out.println(result);
		
	} // end of main
	
	static void comb(int start, int idx) { // 벽 세우기 조합 (브루트포스)
		if(idx == 3) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					copyMap[r][c] = map[r][c];
				}
			}
			for(Node node : q) {
				copyQ.add(node);
			}
			bfs(); // 바이러스 퍼트리기
			int thisCycleSafeArea = countSafeArea(); // 안전영역 구학
			if(result < thisCycleSafeArea) result = thisCycleSafeArea;
			return;
		}
		
		for(int i=start; i<emptyZone.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				int r = emptyZone.get(i).r;
				int c = emptyZone.get(i).c;
				map[r][c] = 1;
				comb(i+1, idx+1);
				visited[i] = false;
				map[r][c] = 0;
			}
		}
	} // end of comb
	
	static void bfs() { // 세균 퍼트리기
		while(!copyQ.isEmpty()) {
			Node curr = copyQ.poll();
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(copyMap[nr][nc] == 0) {
					copyQ.add(new Node(nr, nc));
					copyMap[nr][nc] = 2;
				}
			}
		}
	} // end of bfs
	
	static int countSafeArea() { // 안전지역 영역 구하기
		int result = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(copyMap[r][c] == 0) result++;
			}
		}
		return result;
	} // end of countSafeArea 
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	} // end of checker
	
} // end of class
