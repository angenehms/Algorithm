import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
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
	
	static int N;
	static int M;
	static int[][] map;
	
	static boolean[][][] visited;
	static Deque<Node> q;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		if(N == 1 && M == 1) { // 이거 반례였음 이거 안써서 틀렸었음
			System.out.println(1);
			return;
		}
		// 반례 입력
		// 1 1
		// 0
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		q = new ArrayDeque<>();
		bfs(0, 0, 1);
		
		System.out.println(answer);
		
	} // end of main
	
	static void bfs(int r, int c, int level) {
		q.add(new Node(r,c,level));
		visited[r][c][0] = true; // 출발지 벽 부순적 없으니
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			level = curr.level;
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(isEnd()) {
					answer = level+1;
					return;
				}
				if(!checker()) continue;
				if(map[nr][nc] == 1 && visited[curr.r][curr.c][0] && !visited[nr][nc][1]) { // 다음 칸이 벽이고, 현재 노드까지 벽을 부순 적이 없고, 갈 지점을 이전에 방문한적이 없으면
					q.add(new Node(nr, nc, level+1));
					visited[nr][nc][1] = true;
				} else if (map[nr][nc] == 0 && visited[curr.r][curr.c][0] && !visited[nr][nc][0]) { // 다음 칸이 벽이 아니고, 현재 노드까지 벽을 부순 적이 없으면, 갈 지점을 이전에 방문한적이 없으면
					q.add(new Node(nr, nc, level+1));
					visited[nr][nc][0] = true;
				} else if (map[nr][nc] == 0 && visited[curr.r][curr.c][1] && !visited[nr][nc][1]) { // 다음 칸이 벽이 아니고, 현재 노드까지 벽을 부순 적이 있으면. 갈 지점을 이전에 방문한적이 없으면
					q.add(new Node(nr, nc, level+1));
					visited[nr][nc][1] = true;
				}
			}
		
		
		}
		answer = -1;
	} // end of bfs
	
	static boolean isEnd() {
		return (nr == N-1) && (nc == M-1);
	} // end of isEnd
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	} // end of checker
	
} // end of class
