import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N; // 문제의 갯수
	static int P; // 문제 번호
	static int L; // 문제 난이도
	static int M; // 입력 명령 갯수
	
	static int[] arr;
	static int[] levels;
	
	
//	static PriorityQueue<Node> pq;
//	static class Node implements Comparable<Node> {
//		int number;
//		int level; 
//		Node(int problem, int level) {
//			this.number = problem;
//			this.level = level;
//		}
//		public int compareTo(Node o) {
//			int temp = this.level - o.level;
//			if(temp == 0) {
//				return this.number - o.number;
//			}
//			return temp;
//		}
// 	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
//		pq = new PriorityQueue<>();
		
		arr = new int[100001];
		levels = new int[101];
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			arr[number] = level;
			levels[level]++;
		}
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			
			int x = 0;
			int number = 0;
			int level = 0;
			
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("recommend")) {
				
				x = Integer.parseInt(st.nextToken());
				
				if(x==1) {
					int mostHard = getMaxIndex(); // 가장 어려운 문제의 난이도
//					sb.append(mostHard).append("\n"); // 가장 어려운 문제번호 sb 부착
//					System.out.println("mostHard : " + mostHard);
					sb.append(getFirstHard(mostHard, arr)).append("\n"); // 가장 어려운 문제번호 sb 부착
				} else if(x==-1) {
					int mostEasy = getMinIndex(); // 가장 어려운 문제의 난이도
//					sb.append(mostEasy).append("\n"); // 가장 쉬운 문제번호 sb 부착
//					System.out.println("mostEasy : " + mostEasy);
					sb.append(getFirstEasy(mostEasy, arr)).append("\n"); // 가장 쉬운 문제번호 sb 부착
				}
				
			} else if(order.equals("add")) {
				
				number = Integer.parseInt(st.nextToken());
				level = Integer.parseInt(st.nextToken());
				
				arr[number] = level;
				levels[level]++;
				
			} else if(order.equals("solved")) {
				
				number = Integer.parseInt(st.nextToken());
				int tempLevel = arr[number];
				arr[number] = 0; // 해당 레벨인 문제가 1개 이하라면
				levels[tempLevel]--;
				
			}
			
		}
		
		System.out.println(sb);
		
	} // end of main

	static int getMaxIndex() { // 가장 어려운 문제의 난이도
		int length = arr.length;
		int max = 0;
		for(int i=0; i<length; i++) {
			if(arr[i] == 0) continue;
			if(arr[i] > max) { // 난이도 비교
				max = arr[i];
			}
		}
		return max;
	} // end of getMaxIndex
	
	static int getMinIndex() {// 가장 쉬운 문제의 난이도
		int length = arr.length;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<length; i++) {
			if(arr[i] == 0) continue;
			if(arr[i] <= min) { // 난이도 비교
				min = arr[i];
			}
		}
		return min;
	} // end of getMaxIndex
	
	static int getFirstHard(int levels, int[] arr) {
		int length = arr.length;
		for(int i=length-1; i>=0; i--) {
			if(arr[i] == levels) {
				return i;
			}
		}
		return -1;
	} // end of getFirstHard
	
	static int getFirstEasy(int levels, int[] arr) { // 1 
		int length = arr.length;
		for(int i=0; i<length; i++) {
			if(arr[i] == levels) {
				return i;
			}
		}
		return -1;
	} // end of getFirstEasy
	
} // end of class
