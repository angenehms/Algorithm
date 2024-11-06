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
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			char[] arr = new char[S.length()];
			for(int i=0; i<S.length(); i++) {
				for(int j=0; j<N; j++) {
					sb.append(S.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	
	} // end of main

} // end of class
