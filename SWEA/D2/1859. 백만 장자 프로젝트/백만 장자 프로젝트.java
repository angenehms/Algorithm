import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			long sum = 0;
			for(int i=N-1; i>=0; i--) { // 뒤에서부터 순회
				if(arr[i] > max) {
					max = arr[i];
				} else {
					sum += max - arr[i];
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		} // end of tc 
	System.out.println(sb);
	} // end of main

} // end of class
