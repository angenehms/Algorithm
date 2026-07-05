import java.util.*;

class Solution {
    
    static class Now {
        int sheep;               // 현재 양 수
        int wolf;                // 현재 늑대 수
        List<Integer> nextNodes; // 다음 방문 가능한 곳 후보

        public Now(int sheep, int wolf, List<Integer> nextNodes) {
            this.sheep = sheep;
            this.wolf = wolf;
            this.nextNodes = nextNodes;
        }
    } // end of Now
    
    static List<Integer>[] graph;
    static Deque<Now> q;
    static int maxSheep = 0; // 최대 양 수
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        
        q = new ArrayDeque<>();
        
        // 그래프 초기화
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 그리기
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            graph[from].add(to);
        }
    
        bfs(info);
        
        return maxSheep;
        
    } // end of solution
    
    static void bfs(int[] info) {
        
        // 루트 노드의 자식들을 start 후보로
        List<Integer> startNext = new ArrayList<>();
        for (Integer child : graph[0]) {
            startNext.add(child);
        }
        
        // 루트 노드는 항상 양이므로 양1 늑대0
        q.add(new Now(1, 0, startNext));
        
        while (!q.isEmpty()) {
            Now curr = q.poll();
            
            // 최대로 모은 양 수 갱신
            if (curr.sheep > maxSheep) {
                maxSheep = curr.sheep;
            }
            
            // 다음 노드 탐색
            for (int i = 0; i < curr.nextNodes.size(); i++) {
                int nextNode = curr.nextNodes.get(i);
                
                // 다음 노드 방문 시 계산
                int nextSheep = curr.sheep + (info[nextNode] == 0 ? 1 : 0);
                int nextWolf = curr.wolf + (info[nextNode] == 1 ? 1 : 0);
                
                // 늑대가 양과 같거나 많으면 continue
                if (nextWolf >= nextSheep) continue;

                List<Integer> newNextNodes = new ArrayList<>(curr.nextNodes);
                
                // 현재 방문 Now 빼기 -> 그 자식들을 새로 추가
                newNextNodes.remove(i);
                for (Integer child : graph[nextNode]) {
                    newNextNodes.add(child);
                }
                
                q.add(new Now(nextSheep, nextWolf, newNextNodes));
            }
        }
        
    } // end of bfs
    
} // end of class