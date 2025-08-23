import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	} // end of Node
	
	static int N;
	static int M;
	static int K;
	
	static int[][] map;
	
	// 상하좌우
	static int[] dr = new int[] {-1,1,0,0};
	static int[] dc = new int[] {0,0,-1,1};
	
	static int nr;
	static int nc;
	
	static Deque<Node> q;
	static boolean[][] visited;
	static int rectangleCnt=0;
	static List<Integer> sizeList;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sizeList = new ArrayList<>();
		for(int r=0; r<K; r++) {
			st = new StringTokenizer(br.readLine());
			int leftX = Integer.parseInt(st.nextToken());
			int upY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int downY = Integer.parseInt(st.nextToken());
			draw(leftX, upY, rightX, downY);
		}
		
//		for(int i=0; i<=N; i++) {
//			System.out.println();
//			for(int j=0; j<=M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//		}
//		
//		System.out.println();

		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 1) continue; // 1인 좌표는 넘어가기
				rectangleCnt++;
				bfs(new Node(r,c));
			}
		}
		
		sb.append(rectangleCnt).append("\n");
		
		Collections.sort(sizeList);
		
		for(int num : sizeList) {
			sb.append(num).append(" ");
		}
		
		System.out.println(sb);
		
	} // end of main
	
//	static boolean isContinue() {
//		for(int r=0; r<N+1; r++) {
//			for(int c=0; c<N+1; c++) {
//				if(map[r][c] == 0) return true;
//			}
//		}
//		return false;
//	} // end of isEnd
	
	static void bfs(Node node) {
		
		visited = new boolean[N][M];
		q = new ArrayDeque<>();
		int rectangleSize = 0;
		
		q.add(node);
		map[node.r][node.c] = 1;
		rectangleSize++;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(map[nr][nc] == 0) {
					q.add(new Node(nr, nc));
					map[nr][nc] = 1;
					rectangleSize++;
				}
				
			}
		}
		sizeList.add(rectangleSize);
	} // end of bfs
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<M; 
	}
	
	static void draw(int leftX, int upY, int rightX, int downY) {
		for(int r=upY; r<downY; r++) {
			for(int c=leftX; c<rightX; c++) {
				map[r][c] = 1;
			}
		}
	} // end of draw
	
} // end of class
