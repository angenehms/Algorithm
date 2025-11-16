import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	// 처음 아기상어 크기 2, 1초에 한칸 이동
	// 큰 물고기칸 못지나감, 나머지칸은 지나감
	// 작은 물고기만 먹을 수 있고, 크기가 같은 경우는 못먹고 지나갈 수만 있음
	// 공간에 물고기 없으면 엄마 상어에게 도움요청
	// 먹을 수 있는 물고기 1마리면 그거먹고, 그 이상이면 가장 가까운
	// 거리 가까운 물고기 많으면 가장 위에있는 물고기, 그런 물고기 여러마리면 가장 왼쪽
	// 먹은 칸은 빈칸 됨
	// 먹으면 현재 크기에서 크기 1 증가
		
	static int N;
	static int[][] map;
	
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int size;
		int level;
		Node(int r, int c, int size, int level) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.level = level;
		}
		public int compareTo(Node o) {
			if(this.r != o.r) return this.r - o.r;
			return this.c - o.c;
		}
	} // end of Node
	
	static Node baby;
	
	static int time = 0;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	static int nr;
	static int nc;
	
	static Deque<Node> q;
	static boolean[][] visited;
	
	static PriorityQueue<Node> net; // 가장 위쪽 우선, 그다음은 왼쪽우선
	
	static int startR;
	static int startC;
	
	static boolean isHelped;
	
	static int howFull;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// map 그리기
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 9) {
					baby = new Node(r,c, 2, 0);
					// 초기 위치를 temp 로 두면 나중에 이걸 물고기 크기로 알아버림 !! 
					// 9는 크기가 아니라 아기상어 초기위치를 알리기 위한 숫자임 .. 
					// 고로 아기상어가 이동하면 0이 되게끔 해야함
					map[r][c] = 0;
					continue;
				}
				map[r][c] = temp; 
			}
		}
		
		while(!isHelped) { // 엄마 상어에게 도움을 요청할 떄 까지 반복 
			bfs();
			eat();
		}
		
		System.out.println(time);
		
		
	} // end of main
	
	static void bfs() {
		
		visited = new boolean[N][N];
		net = new PriorityQueue<>();
		
		// 처음 bfs 시작은 항상 아기상어 기준이니까!
		int babyR = baby.r;
		int babyC = baby.c;
		int babySize = baby.size;
		int standardLevel = 0;
		
		q = new ArrayDeque<>();
		q.add(new Node(babyR, babyC, babySize, 0));
		visited[babyR][babyC] = true;
		
		while(!q.isEmpty()) {
			
			Node curr = q.poll();
			int currLevel = curr.level;
			
			// 다음 레벨로 넘어갈 때
			// net 에 담긴 먹이가 있으면
			// 중단 즉, return
			if(standardLevel != currLevel && net.size() != 0) return;
			
			standardLevel = currLevel;
			
			for(int i=0; i<4; i++) { 
				
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				
				if(!checker(nr, nc)) continue;
				int foodSize = map[nr][nc];
				
				// 방문하지 않고 먹이 크기가 같거나 작으면, 혹은 그 칸이 빈칸이면
				if(!visited[nr][nc] && babySize >= foodSize) { 
					
					q.add(new Node(nr, nc, foodSize, currLevel + 1));
					visited[nr][nc] = true;
					
					if(foodSize != 0 && babySize > foodSize) { // 빈칸이 아니고, 먹이 크기가 작으면
						net.add(new Node(nr, nc, foodSize, currLevel + 1));
					}
					
				}
			}
			
		}
		
		
	} // end of bfs
	
	static void eat() {
		
		// bfs 후에도 먹이 없으면 엄마 상어에게 도움 요청
		if(net.size() == 0) {
			isHelped = true;
			return;
		}
		
		Node food = net.poll();
		
		// 아기상어 상태 업데이트
		baby.r = food.r; // 먹었으니 그 자리로
		baby.c = food.c; // 먹었으니 그 자리로
		
		howFull++; // 뱃속 먹이 증가
		if(baby.size == howFull) {
			baby.size++; // 자신의 크기와 같은 수의 물고기를 먹었으면 아기상어 사이즈업
			howFull = 0; // 사이즈 업 했으니 뱃속은 초기화 // 이거 안써서 오류났었음
		}

		map[baby.r][baby.c] = 0; // 먹은 자리는 빈칸으로
		time = time + food.level;
		
	} // end of eat
	
	static boolean checker(int nr, int nc) {
		
		return 0<=nr && nr<N && 0<=nc && nc<N; 
		
	} // end of checker
	
} // end of class
