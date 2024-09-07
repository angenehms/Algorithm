import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[N+1];
		for(int i=1; i<=N; i++) {
			basket[i] = i;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for(int j=start; j<start + (end-start+1)/2; j++) {

				int temp = basket[j];
				basket[j] = basket[end-j+start];
				basket[end-j+start] = temp;
			}

		}
		for(int i=1; i<=N; i++) {
			sb.append(basket[i]).append(" ");
		}
		System.out.println(sb);
	} // end of main

} // end of class
