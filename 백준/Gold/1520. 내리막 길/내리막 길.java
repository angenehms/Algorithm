import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int[][] dp;   // visited 필요 없음 dp 배열이 그 역할 해줄거임

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];

        // dp 초기화 (-1 로 초기화, -1 인 곳은 방문하지 않은 곳이라고 생각해도 됨)
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                dp[r][c] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    } // end of main

    static int dfs(int r, int c) {

    	// 도착지점
        if (r == N - 1 && c == M - 1) {
            return 1;
        }

        // 이미 계산한 칸이면 바로 반환 -> visited 배열 비스무리
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!checker(nr, nc)) continue;
            if (map[r][c] <= map[nr][nc]) continue;

            dp[r][c] += dfs(nr, nc);
        }

        return dp[r][c];
        
    } // end of dfs
    
    static boolean checker(int nr, int nc) {
    	return 0<=nr && nr<N && 0<=nc && nc<M;
    } // end of checker
    
} // end of class