import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Pos {
		int r;
		int c;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int R;
	static int C;
	
	static char[][] map;
	static boolean[] visited;
	
	static int max = Integer.MIN_VALUE;
	
	// 상하좌우
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static int dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 입력 받기
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken()); 
		
		// map 초기화 및 map 그리기
		map = new char[R+1][C+1]; 
		for(int r=1; r<R+1; r++) {
			String str = br.readLine();
			for(int c=1; c<C+1; c++) {
				map[r][c] = str.charAt(c-1);
			}
		}
		
		visited = new boolean[26];
        max = 1; // max 값을 1로 초기화 (출발 칸 포함)
        dfs(new Pos(1,1), 1); // cnt를 1로 시작
        System.out.println(max);
		
	} // end of main
	
//	static void dfs(Pos pos, int cnt) {
//		
//		if(visited[map[pos.r][pos.c]-'A']) {
//			max = Math.max(max, cnt);
//			return;
//		} else {
//			// 현재 위치한 알파벳 방문처리
//			visited[map[pos.r][pos.c]-'A'] = true;
//			for(int i=0; i<4; i++) {
//				nr = pos.r + dr[i];
//				nc = pos.c + dc[i];
//				if(!checker()) continue;
////				if(!visited[map[nr][nc]-'A']) {
//					dfs(new Pos(nr, nc), cnt+1);
////				}
//			}
//			visited[map[pos.r][pos.c]-'A'] = false;
//		}
//		
//		
//		
//	} // end of dfs
	
	static void dfs(Pos pos, int cnt) {
        // 현재 위치의 알파벳을 방문 처리
        visited[map[pos.r][pos.c]-'A'] = true;
        
        // 현재까지의 최대 길이를 업데이트
        max = Math.max(max, cnt);
        
        // 상하좌우로 이동
        for(int i=0; i<4; i++) {
            int nr = pos.r + dr[i];
            int nc = pos.c + dc[i];
            
            // 보드 범위 체크
            if(nr >= 1 && nr <= R && nc >= 1 && nc <= C) {
                // 이동하려는 칸의 알파벳이 방문하지 않은 알파벳인지 확인
                if(!visited[map[nr][nc]-'A']) {
                    dfs(new Pos(nr, nc), cnt+1);
                }
            }
        }
        
        // 백트래킹: 현재 위치의 알파벳 방문 상태를 되돌려 다른 경로 탐색 가능하게 함
        visited[map[pos.r][pos.c]-'A'] = false;
    }
	
	
	static boolean checker() {
		return 1<=nr && nr<R+1 && 1<=nc && nc<C+1;
	} // end of checker
	
} // end of class
