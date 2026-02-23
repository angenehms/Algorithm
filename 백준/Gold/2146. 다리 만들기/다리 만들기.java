import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	
	static class Node {
		int r;
		int c;
		int color;
		int dist; // 최단거리 찾을 때 쓸 변수
		Node(int r, int c, int color, int dist) {
			this.r = r;
			this.c = c;
			this.color = color;
			this.dist = dist;
		}
	}
	
	static Deque<Node> q;
	static Deque<Node> silQ; // 섬 가장자리 노드 담는 큐
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static int color = 1;
	
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화 및 그리기
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		silQ = new ArrayDeque<>();
		
		// 그래프 섬 영역 나누기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int temp = map[r][c];
				if(temp == 1) {
					color++;
					setIslandAreaBfs(r,c);
				}
			}
		}
		
		// silQ 에 담긴 노드들 꺼내서 최단거리 구하기
		while(!silQ.isEmpty()) {
			Node silNode = silQ.poll();
			findShortestBfs(silNode);
		}
		
		System.out.println(result);
//		print();
		
	} // end of main
	
	static void setIslandAreaBfs(int r, int c) {
		
		q = new ArrayDeque<>();
		visited = new boolean[N][N];
		
		map[r][c] = color;
		q.add(new Node(r,c,color,0));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int currR = curr.r;
			int currC = curr.c;
			for(int i=0; i<4; i++) {
				nr = currR + dr[i];
				nc = currC + dc[i];
				if(!checker()) continue;
				if(!visited[nr][nc]) {
					if(map[nr][nc] == 1) {
						map[nr][nc] = color;
						q.add(new Node(nr,nc,color,0));
						visited[nr][nc] = true;
					} else {
						silQ.add(new Node(currR,currC,color,0));
					}
					
				}
			}
		}
		
	} // end of setIslandAreaBfs
	
	static void findShortestBfs(Node silNode) {
		
		q = new ArrayDeque<>();
		visited = new boolean[N][N];
		
		q.add(silNode);
		visited[silNode.r][silNode.c] = true;
		
		int nowIsland = silNode.color;
		
		while(!q.isEmpty()) {
			
			Node curr = q.poll();
			int currR = curr.r;
			int currC = curr.c;
			int currDist = curr.dist;
			
			for(int i=0; i<4; i++) {
				nr = currR + dr[i];
				nc = currC + dc[i];
				if(!checker()) continue;
				int next = map[nr][nc];
				if(!visited[nr][nc] && next != nowIsland) {
					if(next != 0) { // 다른 섬 위이면?
						result = Math.min(result, currDist);
						return; // 최단 섬 찾으면 findShortestBfs 종료
					}
					q.add(new Node(nr,nc,nowIsland,currDist+1));
					visited[nr][nc] = true;
				}
			}
			
		}
		
	} // end of findShortestBfs
	
	static void print() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	} // end of print
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<N;
	} // end of checker;
	
} // end of class
