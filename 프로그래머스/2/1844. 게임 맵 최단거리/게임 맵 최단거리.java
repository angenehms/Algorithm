import java.util.*;

class Solution {
    
    static class Node {
        int r;
        int c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    } // end of Node
    
    static int R;
    static int C;
    
    // 상하좌우
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    
    static int nr;
    static int nc;
    
    static int[][] visited;
    
    static Deque<Node> q;
    
    static int moveCnt = 0;
    
    public int solution(int[][] maps) {
        
        R = maps.length;
        C = maps[0].length;
        
        q = new ArrayDeque<>();
        visited = new int[R][C];
        
        return bfs(new Node(0,0), maps);
        
    } // end of main
    
    static int bfs(Node start, int[][] maps) {
    
        q.add(start);
        moveCnt++;
        visited[start.r][start.c] = moveCnt;
        
        while(!q.isEmpty()) {

            Node curr = q.poll();
            moveCnt = visited[curr.r][curr.c];

            for(int i=0; i<4; i++) {
                nr = curr.r + dr[i];
                nc = curr.c + dc[i];
                if(!checker()) continue;
                if(visited[nr][nc] == 0 && maps[nr][nc] == 1) { // 방문한 적 없고 갈 수 있는 곳이면
                    
                    if(nr == R-1 && nc == C-1) return moveCnt+1; // 목적지 도착시엔 바로 return
                    
                    q.add(new Node(nr, nc));
                    visited[nr][nc] = moveCnt + 1;
                    
                }
            }
            
        }
        return -1;
        
    } // end of bfs
    
    static boolean checker() {
        return 0<=nr && nr<R && 0<=nc && nc<C;
    } // end of checker
    
} // end of class