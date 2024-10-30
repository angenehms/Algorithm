import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase<=T; testCase++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) { // 시간이 순서대로 담긴 우선순위 큐
				pq.add(Integer.parseInt(st.nextToken()));
			}
			
			int fishCnt = 0;
			
			for(int i=0; i<N; i++) { 
				int pollValue = pq.poll();
				fishCnt = (pollValue/M) * K - (i+1);
				if(fishCnt < 0) {
					sb.append("#").append(testCase).append(" ").append("Impossible").append("\n");
					break;
				}	
			}
	
			if(fishCnt>=0) {
				sb.append("#").append(testCase).append(" ").append("Possible").append("\n");
			}
			
		}		
		System.out.println(sb);
	
	} // end of main

} // end of class
