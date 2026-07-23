import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        
        int number; // 노드 넘버링 1부터
        int x;
        int y;
        
        Node left;  // 왼쪽 노드(자식)
        Node right; // 오른쪽 노드(자식)

        public Node(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Node o) {
            if (this.y == o.y) return this.x - o.x; // x 오름차순
            return o.y - this.y; // y 내림차순            
        }
        
    } // end of Node

    static List<Integer> preOrderList;
    static List<Integer> postOrderList;

    public int[][] solution(int[][] nodeinfo) {
        
        int N = nodeinfo.length;
        Node[] nodes = new Node[N];

        // 노드 초기화
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // y 내림차, x 오름차 정렬 !!
        Arrays.sort(nodes);

        // 트리
        Node root = nodes[0]; // 루트 노드
        for (int i = 1; i < N; i++) {
            insertNode(root, nodes[i]);
        }

        preOrderList = new ArrayList<>();
        postOrderList = new ArrayList<>();

        // 순회 시작 !!
        preOrder(root);
        postOrder(root);

        // 정답 배열
        int[][] answer = new int[2][N];
        for (int i = 0; i < N; i++) {
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }

        return answer;

    } // end of solution

    // 트리에 노드 삽입하는 메서드
    static void insertNode(Node parent, Node child) {
        
        if (child.x < parent.x) { // 자식 x가 부모 x보다 작으면 왼쪽 !!
            
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
            
        } else { // 자식 x가 부모 x보다 크면 오른쪽 !!
            
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
            
        }

    } // end of insertNode

    // 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
    static void preOrder(Node node) {
        
        if (node == null) return;

        // 루트 방문
        preOrderList.add(node.number); 
        
        // 탐색
        preOrder(node.left);
        preOrder(node.right);
        
    } // end of preOrder

    // 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
    static void postOrder(Node node) {
        
        if (node == null) return;

        // 탐색
        postOrder(node.left);
        postOrder(node.right);
        
        // 루트 방문
        postOrderList.add(node.number); 
        
    } // end of postOrder

} // end of class