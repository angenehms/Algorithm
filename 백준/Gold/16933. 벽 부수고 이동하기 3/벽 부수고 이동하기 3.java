import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	// 목적 (1,1) -> (N,M)
	// 최단 경로 가장 적은 개수의 칸
	// 시작, 끝 칸도 센다, 이동하지 않고 칸에 머물러 있어도 됨(이 경우에도 낮밤 바뀜)
	// 벽은 낮에만 부술 수 있음 
	// 벽을 K 개 까지 부수고 이동하는 게 더 경로가 짧아지면 K 개 까지 부수고 이동해도 됨
	// (1<= N<= 1000) (1<=M<=1000) (1<=K<=10)
	// 1,1 N,M 은 항상 0
	// 첫째줄에 최단거리 출력, 불가능일땐 -1
	
	static class Node {
		
		int r;
		int c;
		int cnt;
		int wall;
		boolean isDay;
		
		Node(int r, int c, int cnt, int wall, boolean isDay) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.wall = wall;
			this.isDay = isDay;
		}
		
	} // end of Node
	
	// 입력
	static int N;
	static int M;
	static int K;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	static int nr;
	static int nc;
	
	static int[][] map;
	
	// bfs
	static boolean[][][] visited;
	static Deque<Node> q;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// map 초기화 및 만들기
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c) -'0';
			}
		}
		
		if(N==1 && M==1 ) {
			System.out.print(1);
			return;
		}
		
		visited = new boolean[N][M][K+1];
		q = new ArrayDeque<>();
		bfs(new Node(0, 0, 1, 0, true));
		
		System.out.print(answer);
		
	} // end of main
	
	static void bfs(Node start) {
		
		q.add(start);
		visited[start.r][start.c][start.wall] = true; // 방문처리
		
		while(!q.isEmpty()) {
			
			Node curr = q.poll();
			
			for(int i=0; i<4; i++) {
				
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				
				if(!checker()) continue;
				
				// 다음 칸이 목적지면 return
				if(nr == N-1 && nc == M-1) {
					answer = curr.cnt + 1;
					return;
				}
						
				if(curr.isDay) { // 지금 낮일 때
					
					if(map[nr][nc] == 1) { // 낮 -> 다음 칸이 벽이면
						// 움직일 벽이 남아있고 && 이동할 곳이 방문한 적 없을때
						if(curr.wall<K && !visited[nr][nc][curr.wall+1]) { 
							q.add(new Node(nr,nc,curr.cnt+1,curr.wall+1,false));
							visited[nr][nc][curr.wall+1] = true;
						}
					} else { // 낮 -> 다음 칸이 벽이 아니면
						// 다음 칸으로 이동
						if(!visited[nr][nc][curr.wall]) {
							q.add(new Node(nr,nc,curr.cnt+1,curr.wall,false));
							visited[nr][nc][curr.wall] = true;
						}
					}
				
				} else { // 지금 밤일 때는 어차피 제자리에 있어야함
					if(map[nr][nc] == 1) { // 벽이면
						q.add(new Node(curr.r,curr.c,curr.cnt+1,curr.wall,true));
					} else { // 벽이 아니면
						q.add(new Node(nr,nc,curr.cnt+1,curr.wall,true));
					}
				}
				
			}
		}
		
		answer = -1;
		
	} // end of bfs
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	 } // end of checker
	
} // end of class
