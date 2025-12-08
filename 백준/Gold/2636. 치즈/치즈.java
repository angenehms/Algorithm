import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int height;
	static int width;
	
	static int[][] map;
	
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
	static boolean[][] visited;
	
	static int thisCycleCnt;
	static int time;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		map = new int[height][width];
		for(int r=0; r<height; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<width; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(!isAllZero()) {
			bfs(new Node(0,0));
		}
		
		sb.append(time).append("\n").append(thisCycleCnt);
		System.out.println(sb);
		
	} // end of main
	
	static void bfs(Node node) {
		
		q = new ArrayDeque<>();
		visited = new boolean[height][width];
		thisCycleCnt = 0;
		time++;
		
		q.add(node);
		visited[node.r][node.c] = true;
		
		
		while(!q.isEmpty()) {
			Node curr = q.poll();			
			
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(visited[nr][nc]) continue;
				int temp = map[nr][nc];
				if(temp == 0) {
					q.add(new Node(nr,nc));
					visited[nr][nc] = true;
				}
				if(temp == 1) {
					thisCycleCnt++;
					map[nr][nc] = 0;
					visited[nr][nc] = true;
				}
			}
			
		}
		
	} // end of bfs
	
	static boolean isAllZero() {
		for(int r=0; r<height; r++) {
			for(int c=0; c<width; c++) {
				if(map[r][c] == 1) return false;
			}
		}
		return true;
	} // end of isAllZero
	
	static boolean checker() {
		return 0<=nr && nr<height && 0<=nc && nc<width;
	} // end of checker
	
} // end of class
