import java.util.*;

class Solution {

    static boolean[] visited;
    static List<Integer>[] winGraph;
    static List<Integer>[] loseGraph;

    public int solution(int n, int[][] results) {
        
        // 그래프 초기화
        winGraph = new ArrayList[n + 1];
        loseGraph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }

        // 그래프 만들기
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            winGraph[winner].add(loser);
            loseGraph[loser].add(winner);
        }

        int answer = 0;
 
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int wins = dfs(i, winGraph) - 1; // 자기 자신 제외 (이긴 사람 수)
            
            visited = new boolean[n + 1];
            int loses = dfs(i, loseGraph) - 1; // 자기 자신 제외 (진 사람 수)
            
            if (wins + loses == n - 1) {
                answer++;
            }
        }
        
        return answer;
        
    } // end of solution
    
    static int dfs(int start, List<Integer>[] graph) {
        visited[start] = true;
        int count = 1; // 자기 자신 카운트
        
        for (int next : graph[start]) {
            if (!visited[next]) {
                count += dfs(next, graph);
            }
        }
        
        return count;
    } // end of dfs
    
} // end of class