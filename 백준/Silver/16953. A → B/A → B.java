import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int A;
	static int B;

	static Deque<Node> q;
	static class Node {
		long from;
		int level;
		Node(long from, int level) {
			this.from = from;
			this.level = level;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		bfs(new Node(A, 0));
		
	} // end of main
	
	static void bfs(Node node) {
		
		q = new ArrayDeque<>();
		q.add(node);
		while(!q.isEmpty()) {
			Node curr = q.poll();
			long from = curr.from;
			int currLevel = curr.level;
			
			long multiple = from*2;
			long rightAdd = Long.parseLong(from + "" + 1);
			
			if(multiple == B || rightAdd == B) {
				System.out.println(currLevel+2);
				return;
			} 
			
			if (multiple < B) {
				q.add(new Node(multiple, currLevel+1));
			}
			
			if (rightAdd < B) {
				q.add(new Node(rightAdd, currLevel+1));
			}
			
		}
		
		// from == B 가 안돼서 while 루프를 나오게 되면
		System.out.println(-1);
		
	} // end of bfs
	
} // end of class
