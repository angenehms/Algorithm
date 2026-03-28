import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String first = br.readLine();
		String second = br.readLine();
		
		int fL = first.length();
		int sL = second.length();
		
		// 최소 길이
		int[][] dp = new int[fL+1][sL+1];
		
		for(int i=1; i<=fL; i++) {
			
			for(int j=1; j<=sL; j++) {
				if(first.charAt(i-1) == second.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[fL][sL]);
		
	} // end of main
	
} // end of class
