import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static class Node {
		char alp;
		Node(char alp) {
			this.alp = alp;
		}
	} // end of Node
	
	static Map<Character, char[]> graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new HashMap<>();
		
		char root = 'A';
		// 그래프 그리기
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			char first = str.charAt(0);
			char left = str.charAt(2);
			char right = str.charAt(4);
			graph.put(first, new char[] {left, right});
		}
		
		preOrder(root);
		sb.append("\n");
		inOrder(root);
		sb.append("\n");
		postOrder(root);
		
		System.out.println(sb);
		
	} // end of main
	
	static void postOrder(char root) {
		
		char left = graph.get(root)[0];
		char right = graph.get(root)[1];
		
		if(left != '.') {
			postOrder(left);
		}
		
		
		if(right != '.') {
			postOrder(right);
		}
		
		sb.append(root);
		
	} // end of postOrder 
	
	static void inOrder(char root) {
		
		char left = graph.get(root)[0];
		char right = graph.get(root)[1];
		
		if(left != '.') {
			inOrder(left);
		}
		
		sb.append(root);

		
//		if(left == '.') {
//			sb.append(root);
//			inOrder(right);
//		}
		
		if(right != '.') {
			inOrder(right);
		}
		
	} // end of inOrder
	
	static void preOrder(char root) {
		
		sb.append(root);
		
		char left = graph.get(root)[0];
		char right = graph.get(root)[1];
		
		// left
		if(left != '.') {
//			sb.append(left);
			preOrder(left);
		}
		
		// right
		if(right != '.') {
//			sb.append(right);
			preOrder(right);
		}
				
	} // end of perOrder
	
} // end of class
