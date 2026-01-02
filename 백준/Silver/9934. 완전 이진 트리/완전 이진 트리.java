import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int K; // K개의 줄에 걸쳐 정답 출력
	static int nodeCnt; // 주어진 노드 갯수
	
	static PriorityQueue<Node> pq;
	static class Node implements Comparable<Node> {
		int value;
		int level;
		int order;
		Node(int value, int level, int order) {
			this.value = value;
			this.level = level;
			this.order = order; // 0은 왼쪽, 1은 오른쪽
		}
		public int compareTo(Node o) {
			if(this.level == o.level) return this.order - o.order;
			return this.level - o.level;
		}
	} // end of Node
	
	static int[] nodeList;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>();
		nodeCnt = (int) Math.pow(2, K) - 1;
		nodeList = new int[nodeCnt];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<nodeCnt; i++) {
			nodeList[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = nodeCnt-1;
		getMid(left, right, 1);
		
		int standardLevel = 1;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int value = curr.value;
			int level = curr.level;
			if(level != standardLevel) {
				sb.append("\n");
				standardLevel++;
			}
			sb.append(value+" ");
		}
		
		
//		for(Node curr : pq) {
//			int value = curr.value;
//			int level = curr.level;
//			sb.append(value);
//		}
		
		System.out.println(sb);
		
	} // end of main
	
	static void getMid(int left, int right, int level) {
		
		if(left > right) return;
		
		int mid = (left + right) / 2;
		pq.add(new Node(nodeList[mid], level, left));
		
//		System.out.println("1 - left : "+left + " right : " + right);
		
		// 왼쪽
		getMid(left, mid-1, level+1);
		
//		System.out.println("2 - left : "+left + " right : " + right);
		
		// 오른쪽
		getMid(mid+1, right, level+1);
		
//		System.out.println("3 - left : "+left + " right : " + right);
		
	} // end of getMid 
	
} // end of class
