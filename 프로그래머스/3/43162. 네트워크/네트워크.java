import java.util.*;

class Solution {
    
    static List<Integer>[] graph; // 실제 graph
    
    static Deque<Integer> q; // bfs queue
    static int networkCnt = 0; // 네트워크 갯수(정답)
    
    static boolean[] visited; // 방문처리
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        // graph 그리기
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) { // 초기화
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1) { // i 와 j 가 연결되어 있으면
                    graph[i].add(j);
                }
            }
        }
        
        // bfs 돌리기 -> 네트워크 갯수찾기
        for(int i=0; i<n; i++) {
            if(visited[i]) continue; // 탐색 시작 지점이 방문한 적 있는 곳이면 continue
            bfs(i); // 시작 노드는 i
        }
        
        return networkCnt;
        
    } // end of main
    
    static void bfs(int start) {
        
        networkCnt++;
        
        q = new ArrayDeque<>(); // q 초기화
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) { // q 가 빌 때 까지
            
            int curr = q.poll();
            for(int nextNode : graph[curr]) {
                
                if(!visited[nextNode]) {
                    q.add(nextNode);
                    visited[nextNode] = true;
                }
                
            }

        }

    } // end of bfs
    
} // end of class