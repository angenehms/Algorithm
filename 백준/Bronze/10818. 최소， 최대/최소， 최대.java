import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int temp = 0; 
		for(int i =0; i<N; i++) {
			temp = Integer.parseInt(st.nextToken());
			
			min = Math.min(min, temp);
			max = Math.max(max, temp);
		}

		System.out.print(min + " " + max);
		
	} // end of main

} // end of class
