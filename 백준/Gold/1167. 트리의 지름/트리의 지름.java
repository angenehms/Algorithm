import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int node;
    static List<Node>[] graph;
    static class Node {
        int to;
        int weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static int result = 0;
    static int farthestNode = 0; // 지름의 한쪽 끝점을 찾기 위한 변수
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        node = Integer.parseInt(br.readLine());
        graph = new ArrayList[node+1];
        for(int i=0; i<node+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<node; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(to, weight));
            }
        }

        boolean[] visited = new boolean[node+1];
        dfs(1, 0, visited);
        
        visited = new boolean[node+1];
        result = 0; // 결과값 초기화
        dfs(farthestNode, 0, visited);
        
        System.out.println(result);
        
    } // end of main
    
    // 현재까지의 누적 거리를 인자로 받음
    static void dfs(int current, int dist, boolean[] visited) {
        visited[current] = true;
        
        // 현재까지 온 거리가 최대라면 결과값과 해당 노드 갱신
        if (dist > result) {
            result = dist;
            farthestNode = current;
        }

        for(Node next : graph[current]) {
            if(!visited[next.to]) {
                dfs(next.to, dist + next.weight, visited);
            }
        }
    } // end of dfs
    
} // end of class