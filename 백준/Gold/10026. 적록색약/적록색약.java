import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	static int N;
	static String[][] map;

	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static boolean[][] visited;
	
	static int[][] can;
	static int[][] canNot;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// map 그리기
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = String.valueOf(str.charAt(c));
			}
		}
		
		visited = new boolean[N][N];
		Deque<int[]> q = new ArrayDeque<>();
		can = new int[N][N];
		canBfs(q);
		sb.append(getMax(can)).append(" ");
		
		visited = new boolean[N][N];
		q = new ArrayDeque<>();
		canNot = new int[N][N];
		canNotBfs(q);
		sb.append(getMax(canNot));
		
		System.out.println(sb);
		
	} // end of main
	
	static void canBfs(Deque<int[]> q) {
		int cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) { // 방문한적이 없으면
					cnt++;
					q.add(new int[] {r,c});
					visited[r][c] = true;
					can[r][c] = cnt;
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						for(int i=0; i<4; i++) {
							nr = curr[0] + dr[i];
							nc = curr[1] + dc[i];
							if(!checker()) continue;
							if(!visited[nr][nc] && map[nr][nc].equals(map[r][c])) {
								q.add(new int[] {nr, nc});
								visited[nr][nc] = true;
								can[nr][nc] = cnt;
							}
						}
					}
				}
			}
		}
	} // end of canBfs
	
	static void canNotBfs(Deque<int[]> q) {
		int cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) { // 방문한적이 없으면
					cnt++;
					q.add(new int[] {r,c});
					visited[r][c] = true;
					canNot[r][c] = cnt;
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						for(int i=0; i<4; i++) {
							nr = curr[0] + dr[i];
							nc = curr[1] + dc[i];
							if(!checker()) continue;
							if(!visited[nr][nc]) {
								if((map[r][c].equals("R") || map[r][c].equals("G")) && (map[nr][nc].equals("R") || map[nr][nc].equals("G"))) {
									q.add(new int[] {nr, nc});
									visited[nr][nc] = true;
									canNot[nr][nc] = cnt;
								} else if(map[r][c].equals("B") && map[nr][nc].equals("B")) {
									q.add(new int[] {nr, nc});
									visited[nr][nc] = true;
									canNot[nr][nc] = cnt;
								}
							}
						}
					}
				}
			}
		}
	} // end of canNotBfs
	
	static int getMax(int[][] map) {
		int max = Integer.MIN_VALUE;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(max < map[r][c]) {
					max = map[r][c];
				}
			}
		}
		return max;
	} // end of getMax
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<N;
	}
	
} // end of class
