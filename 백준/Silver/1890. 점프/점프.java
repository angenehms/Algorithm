import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static long[][] dp; // 경로의 수를 저장할 메모 배열

    // 우로 이동, 하로 이동
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // -1로 초기화, 즉 방문 안한곳
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static long dfs(int r, int c) {
    	
        // 목적지 도착
        if (r == N - 1 && c == N - 1) return 1;
        
        // 메모이제이션 확인
        if (dp[r][c] != -1) return dp[r][c];
        
        // 현재 위치에서 갈 수 있는 다음 노드 리스트를 생성
        List<Node> nodeList = getNextNodes(r, c);
        
        dp[r][c] = 0; // 현재 위치 초기화
        for (Node next : nodeList) {
            dp[r][c] += dfs(next.r, next.c);
        }

        return dp[r][c];
    }

    // 현재 위치(r, c)에서 점프해서 갈 수 있는 노드 -> 리스트에 담아 반환
    static List<Node> getNextNodes(int r, int c) {
    	
        List<Node> list = new ArrayList<>();
        int jump = map[r][c];

        for (int i = 0; i < 2; i++) {
        	
            int nr = r + dr[i] * jump;
            int nc = c + dc[i] * jump;

            if (checker(nr, nc)) {
                list.add(new Node(nr, nc));
            }
            
        }
        
        return list;
    }

    static boolean checker(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}