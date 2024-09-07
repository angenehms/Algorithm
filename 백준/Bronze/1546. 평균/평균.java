import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		float[] score = new float[N];
		int M = 0;
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			score[i] = temp;
			M = Math.max(M, temp);
		}
		float avgSum = 0;
		for(int i=0; i<N; i++) {
			avgSum += score[i]/M*100;
		}
		System.out.println(avgSum/N);
		
	
	} // end of main

} // end of class
