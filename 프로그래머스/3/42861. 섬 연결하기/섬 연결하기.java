import java.util.*;
class Solution {
    
    static class Node implements Comparable<Node> {
        int to;
        int weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    } // end of Node
    
    static PriorityQueue<Node> pq;
    static List<Node>[] graph;
    static int answer;
    static boolean[] visited;
    
    public int solution(int node, int[][] costs) {
        
        pq = new PriorityQueue<>();
        answer = 0;
        
        // from, to, cost
        graph = new ArrayList[node];
        for(int i=0; i<node; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int weight = costs[i][2];
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }
        
        visited = new boolean[node];
                
        prim(node, 0);
        return answer;
        
        
    } // end of main
    
    static void prim(int node, int start) {
        
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(visited[curr.to]) continue; // 현재 목적지가 이미 방문한 곳이면 빼고

            
            visited[curr.to] = true;
            answer += curr.weight;
            
            for(Node next : graph[curr.to]) { // 여기랑 연결된 간선 다 꺼내
                if(visited[next.to]) continue; // 다음 목적지가 이미 방문한 곳이면 빼고
                pq.add(new Node(next.to, next.weight));
                
            }
            
        }
        
    } // end of prim
} // end of class