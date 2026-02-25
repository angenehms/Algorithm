import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	
	static char[][] map;
	
	// 우상 우 우하
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1}; 
	
//	static int nr;
//	static int nc;
	
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				char temp = str.charAt(c);
				map[r][c] = temp;
			}
		}
		
		for(int i=0; i<R; i++) {
			dfs(i, 0);
		}
		
		System.out.println(result);
		
	} // end of main
	
	static boolean dfs(int r, int c) {
		
		map[r][c] = 'x'; // 방문 처리
		
		if(c == C-1) {
			result++;
			return true;
		}
		
		for(int i=0; i<3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(!checker(nr, nc)) continue;
			if(map[nr][nc] == 'x') continue;
			if(dfs(nr, nc)) {
				return true;
			}
		}
		
		return false;
		
	} // end of bfs
	
	static boolean checker(int nr, int nc) {
		return 0<=nr && nr<R && 0<=nc && nc<C;
	} // end of checker
	
} // end of class
