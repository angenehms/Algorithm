// 43 분 시작
import java.util.*;

class Solution {
    
    static int[] result;
    static class Node {
        int to;
        int level;
        Node(int to, int level) {
            this.to = to;
            this.level = level;
        }
    } // end of Node
    
    static List<Integer>[] graph;
    
    public int[] solution(int node, int[][] line, int[] startArr, int destination) {
        
        graph = new ArrayList[node+1]; // 그래프
        for(int i=0; i<node+1; i++) { // 그래프 초기화
            graph[i] = new ArrayList<>();
        }
        
        boolean[] visited; // 방문처리
        
        int lineN = line.length;
        for(int i=0; i<lineN; i++) {
            int from = line[i][0];
            int to = line[i][1];
            // 양방향
            graph[from].add(to);
            graph[to].add(from);
        }
        
        int startArrN = startArr.length;
        result = new int[startArrN];
        
        for(int i=0; i<startArrN; i++) {
            visited = new boolean[node+1]; // 방문처리 초기화
            bfs(startArr, i, destination, visited);
        }
        
        return result;
        
    } // end of main
    
    static void bfs(int[] startArr, int start, int destination, boolean[] visited) {
    
        int startPlace = startArr[start];
        if(startPlace == destination) {
            result[start] = 0;
            return;
        }
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(startPlace, 0));
        visited[startPlace] = true;
        
        while(!q.isEmpty()) {
            
            Node curr = q.poll();
            int currTo = curr.to;
            int currLevel = curr.level;
            
            for(int next : graph[currTo]) {
                
                if(visited[next]) continue; // 방문한 적 있으면 지나가기
                
                if(next == destination) { // 목적지 도착이면
                    result[start] = currLevel+1; // 한칸 더 간거니까
                    return;
                }

                q.add(new Node(next, currLevel+1));
                visited[next] = true;
                
            }
            
        }
        
        result[start] = -1;
        
    } // end of bfs
    
} // end of class