import java.util.*;

class Solution {

    // 요청하신 방향 배열 적용 (하, 상, 좌, 우 순서)
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    // dr, dc 인덱스에 매핑되는 방향 문자 ('d', 'u', 'l', 'r')
    static char[] charArr = {'d', 'u', 'l', 'r'};
    
    // 사전순(d -> l -> r -> u)으로 탐색하기 위한 인덱스 우선순위 배열 !!
    static int[] priorityOrder = {0, 2, 3, 1}; 

    // 격자 크기 (n, m)
    static int maxR;
    static int maxC;
    
    // 탈출구 (r, c)
    static int endR;
    static int endC;
    
    // 남은 이동 횟수
    static int total;  
    
    static StringBuilder sb;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        maxR = n;
        maxC = m;
        endR = r;
        endC = c;
        
        total = k;
        
        sb = new StringBuilder();

        // 현재 위치에서 목적지까지 최단거리 구하기
        int minDist = getDistance(x, y, endR, endC);

        // 남은 이동 횟수 < 최소 거리
        // (남은 횟수 - 최소 거리 = 홀수) 면 impossible 출력 !!
        if (minDist > k || (k - minDist) % 2 != 0) return "impossible";
        
        dfs(x, y, 0);

        return sb.toString();
        
    } // end of solution

    // 네 방향을 사전순(d -> l -> r -> u)으로 한 칸씩 이동하며 경로 탐색
    static void dfs(int currR, int currC, int count) {
        
        if (count == total) return;

        // priorityOrder(사전순) 순서대로 순회를 위함
        for (int i = 0; i < 4; i++) {
            
            // 해당 이동에 대한 인덱스 가져오기
            int idx = priorityOrder[i];
            
            int nr = currR + dr[idx];
            int nc = currC + dc[idx];

            // 범위 나가면 continue
            if (!checker(nr, nc)) continue;

            // 다음 칸에서 목적지까지의 남은 최소 거리
            int nextRest = getDistance(nr, nc, endR, endC);

            // 남은 이동 횟수 안에 목적지에 도달 가능하면 진입 !!
            if (nextRest <= total - count - 1) {
                
                sb.append(charArr[idx]);
                
                dfs(nr, nc, count + 1);
                
                break; // 사전순으로 가장 먼저 성공한 경로가 정답이므로 바로 종료 !!
            }
        }
    } // end of dfs

    static boolean checker(int r, int c) {
        if (r < 1 || r > maxR || c < 1 || c > maxC) return false;
        return true;
    } // end of checker

    static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    } // end of getDistance

} // end of class