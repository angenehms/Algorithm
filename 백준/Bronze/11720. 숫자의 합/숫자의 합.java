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
		String S = br.readLine();
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += S.charAt(i)-'0';
		}
		System.out.println(sum);
	} // end of main

} // end of class
