import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static char[][] map;
	
	// 상하좌우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int nr;
	static int nc;
	
	static int[][] yesMap;
	static int[][] noMap;
	
	static int yesAreaCnt = 0; // 적록색약으로 보이는 경우
	static int noAreaCnt = 0; // 적록색약이 아닌 경우
	
	static Deque<Node> q;
	
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	} // end of Node

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		// map 초기화 및 그리기
		map = new char[N][N];
		for(int r=0; r<N; r++) {
			String line = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		yesMap = new int[N][N];
		noMap = new int[N][N];
		
		// 적록 색약인 경우
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				yesBfs(r,c);
				noBfs(r,c);
			}
		}
		
		sb.append(noAreaCnt).append(" ").append(yesAreaCnt);
		System.out.println(sb);
		
	} // end of main
	
	static void yesBfs(int r, int c) {
		
		if(yesMap[r][c] != 0) return;
		char color = map[r][c];
		q = new ArrayDeque<>();
		q.add(new Node(r,c));
		yesMap[r][c] = ++yesAreaCnt;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(yesMap[nr][nc] != 0) continue;
				char temp = map[nr][nc];
				if((color == 'R' || color == 'G') && (temp == 'R' || temp == 'G')) { // color가 적록일떄, temp도 적록이면
					q.add(new Node(nr,nc));
					yesMap[nr][nc] = yesAreaCnt;
				} else if(color == 'B') { // color가 블루면
					if(temp == color) {
						yesMap[nr][nc] = yesAreaCnt;
						q.add(new Node(nr,nc));
					}
					
				}
			}
		}
		
		
		
	} // end of yesBfs
	
	static void noBfs(int r, int c) {
		
		if(noMap[r][c] != 0) return;
		char color = map[r][c];
		q = new ArrayDeque<>();
		q.add(new Node(r,c));
		noMap[r][c] = ++noAreaCnt;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(noMap[nr][nc] != 0) continue;
				if(map[nr][nc] == color) {
					q.add(new Node(nr,nc));
					noMap[nr][nc] = noAreaCnt;
				}
			}
		}
		
	} // end of noBfs
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<= nc && nc<N;
	}
	
} // end of class
