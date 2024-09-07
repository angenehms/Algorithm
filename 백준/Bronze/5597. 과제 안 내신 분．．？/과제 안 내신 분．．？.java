import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		boolean[] arr = new boolean[31];
		int breakCnt = 0;
		for(int i=0; i<28; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[n] = true;
		}
		for(int i=1; i<=30; i++) {
			if(!arr[i]) {
				breakCnt++;
				sb.append(i).append("\n");
				if(breakCnt>=2) {
					break;
				}
			}
		}
		System.out.println(sb);
		
	} // end of main

} // end of class
