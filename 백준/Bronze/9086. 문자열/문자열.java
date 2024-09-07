import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			String S = br.readLine();
			char start = S.charAt(0);
			char end = S.charAt(S.length()-1);
			sb.append(start).append(end).append("\n");
		}
		System.out.println(sb);
	} // end of main

} // end of class
