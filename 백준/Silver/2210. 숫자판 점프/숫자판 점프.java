import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MulticastSocket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int r;
		int c;
		int level;
		Node(int r, int c, int level) {
			this.r = r;
			this.c = c;
			this.level = level;
		}
	} // end of Node

	static int N = 5;
	static int[][] map;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	static int nr;
	static int nc;
	
//	static Deque<Node> q;
	static Set<String> hashSet;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// map 초기화 및 그리기
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		q = new ArrayDeque<>();
		result = new int[N+1];
		hashSet = new HashSet<>();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				dfs(new Node(r,c,0));
			}
		}

		System.out.println(hashSet.size());
		
	} // end of main
	
	static void dfs(Node node) {
		int level = node.level;
		if(level==6) {
			hashSet.add(makeStr(result));
			return;
		}
		for(int i=0; i<4; i++) {
			nr = node.r + dr[i];
			nc = node.c + dc[i];
			if(checker() && level<6) {
				result[level] = map[nr][nc];
				dfs(new Node(nr, nc, level+1));
			}
		}
	} // end of dfs
	
	static String makeStr(int[] arr) {
		String str = null;
		for(int i=0; i<=N; i++) {
			str = str+arr[i];
		}
		return str;
	} // end of makeStr
	
//	static void bfs(Node node) {
//		int level = node.level;
//		q.add(node);
//		while(!q.isEmpty()) {
//			Node curr = q.poll();
//			for(int i=0; i<4; i++) {
//				nr = curr.r + dr[i];
//				nc = curr.c + dc[i];
//				if(!checker()) continue;
//				if(level>=5) break;
//				q.add(new Node(nr, nc, level+1));
//			}
//			
//		}
//		
//		return;
//		
//	} // end of bfs
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<N;
	} // end of boolean
	
	
} // end of class
