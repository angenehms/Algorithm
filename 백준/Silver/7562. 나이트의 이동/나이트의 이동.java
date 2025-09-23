import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int length;
	
	static class Node {
		int r;
		int c;
		int level;
		Node (int r, int c, int level) {
			this.r = r;
			this.c = c;
			this.level = level;
		}
	} // end of node

	static boolean[][] map;
	
	static int[] dr = {-2, -2, -1, 1, 2, 2, -1, 1};
	static int[] dc = {-1, 1, -2, -2, -1, 1, 2, 2};
	
	static int nr;
	static int nc;
	
	static Deque<Node> q;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) {
			
			// 입력 세팅
			length = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Node now = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine());
			Node goal = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			// map
			map = new boolean[length][length];
			q = new ArrayDeque<>();
			pickCanMove(now, goal);
		}
		
		System.out.println(sb);
		
	} // end of main
	
	static void pickCanMove(Node now, Node goal) {
		
		q.add(now);
		map[now.r][now.c] = true;
		

		while(!q.isEmpty()) {
			
			Node curr = q.poll();
			if(curr.r == goal.r && curr.c == goal.c) {
				sb.append(curr.level).append("\n");
				return;
			}
			for(int i=0; i<8; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue; // 범위 밖이면 continue
				if(!map[nr][nc]) { // 방문한적 없으면
					q.add(new Node(nr, nc, curr.level+1));
					map[nr][nc] = true;
				}
				
			}
		}
		
	} // end of pickCanMove
	
	static boolean checker() {
		return 0<=nr && nr<length && 0<=nc && nc<length;
	}
	
} // end of class
