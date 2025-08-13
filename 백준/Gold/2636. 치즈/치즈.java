import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static int[][] map;
	
	static Deque<int[]> q;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static boolean[][] visited;
	
	static int time = 0;
	static int remain;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// map 그리기
		map = new int[R][C];
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for( int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(!isAllZero()) {
			remain = 0;
			q = new ArrayDeque<>();
			visited = new boolean[R][C];
			bfs(new int[] {0, 0});
			time++;
		}
		
		sb.append(time).append("\n").append(remain);
		System.out.println(sb);
		
	} // end of main
	
	static void bfs(int[] start) {
		q.add(start);
		visited[start[0]][start[1]] = true;
		while(!q.isEmpty()) {

			int[] curr = q.poll();
			for(int i=0; i<4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(!checker()) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 0) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				} else if(map[nr][nc] == 1) {
					remain++;
					visited[nr][nc] = true;
					map[nr][nc] = 2;
				} else if(map[nr][nc] > 1) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
			
		}
	} // end of bfs
	
	static boolean isAllZero() {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] == 1) return false;
			}
		}
		return true;
	} // end of isAllZero
	
	static boolean checker() {
		return 0<=nr && nr<R && 0<=nc && nc<C;
	}
	
} // end of class
