import java.util.*;

class Solution {

    static class Node {
        int id; // 행 번호
        Node prev; // 이전 노드
        Node next; // 다음 노드

        public Node(int id) {
            this.id = id;
        }
    } // end of Node

    static Node[] nodes;
    static Deque<Node> deletedStack;
    static Node curr; // 현재 선택된 노드

    public String solution(int n, int k, String[] cmd) {
        
        nodes = new Node[n];
        deletedStack = new ArrayDeque<>(); // 큐 초기화

        // 노드 초기화
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        // 연결 리스트
        for (int i = 0; i < n; i++) {
            if (i > 0) nodes[i].prev = nodes[i - 1];
            if (i < n - 1) nodes[i].next = nodes[i + 1];
        }

        // 처음 선택된 행
        curr = nodes[k];

        // 명령어 순차 처리
        for (int i = 0; i < cmd.length; i++) {
            String[] split = cmd[i].split(" ");
            String alpha = split[0];

            if (alpha.equals("U")) {
                int move = Integer.parseInt(split[1]);
                up(move);
            } else if (alpha.equals("D")) {
                int move = Integer.parseInt(split[1]);
                down(move);
            } else if (alpha.equals("C")) {
                clear();
            } else if (alpha.equals("Z")) {
                recover();
            }
        }

        // 결과(일단 다 O 으로)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("O");
        }

        // 그 다음에 삭제된 노드들은 X 로 !!
        while (!deletedStack.isEmpty()) {
            Node pop = deletedStack.pop();
            sb.setCharAt(pop.id, 'X');
        }

        return sb.toString();

    } // end of solution

    // 위로 이동
    static void up(int move) {
        for (int i = 0; i < move; i++) {
            if (curr.prev != null) curr = curr.prev;
        }
    } // end of up

    // 아래로 이동
    static void down(int move) {
        for (int i = 0; i < move; i++) {
            if (curr.next != null) curr = curr.next;
        }
    } // end of down

    // 현재 행 삭제
    static void clear() {
        
        deletedStack.push(curr); // 스택의 top에 추가

        Node prevNode = curr.prev;
        Node nextNode = curr.next;

        // 이전 노드가 존재 -> 이전 노드의 next를 현재 next로 !!
        if (prevNode != null) prevNode.next = nextNode;
        
        // 다음 노드가 존재 -> 다음 노드의 prev를 현재 prev로
        if (nextNode != null) nextNode.prev = prevNode;
        
        // 다음 노드가 없으면(마지막 행인 경우) 이전 노드를 선택 !! 아니면 다음 노드 선택
        if (nextNode == null) {
            curr = prevNode;
        } else {
            curr = nextNode;
        }
        
    } // end of clear

    // 가장 최근에 삭제된 행 복구
    static void recover() {
        
        Node target = deletedStack.pop(); // 가장 최근에 push 된 노드를 꺼냄

        Node prevNode = target.prev;
        Node nextNode = target.next;

        // 이전 노드가 존재하면 복구된 노드와 재연결
        if (prevNode != null) prevNode.next = target;

        // 다음 노드가 존재하면 복구된 노드와 재연결
        if (nextNode != null) nextNode.prev = target;
        
    } // end of recover

} // end of class