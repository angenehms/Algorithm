import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String input = br.readLine();
			int resultCnt = 0;
			int filter = 0;
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i)-'0' != filter) { // charAt 을 int 형으로 바꿔야함 
					if(filter == 0) {
						filter = 1;
					} else {
						filter = 0;
					}
					resultCnt ++;
				}					
			}
			sb.append("#").append(testCase).append(" ").append(resultCnt).append("\n");
		} // end of tc
		System.out.println(sb);
	} // end of main

} // end of class
