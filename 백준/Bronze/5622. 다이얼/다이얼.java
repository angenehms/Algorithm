import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		String[] arr = new String[] {null, "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		String str = br.readLine();
		int resultCnt = 0;
		for(int i=0; i<str.length(); i++) {
			char temp = str.charAt(i);
			for(int j=0; j<arr.length; j++) {
				if(arr[j] == null) continue;
				for(int k=0; k<arr[j].length(); k++) {
					if ( temp == arr[j].charAt(k) ) {
						resultCnt = resultCnt + (j+2);
					}
				}
			}
		}
		System.out.println(resultCnt);
		
	} // end of main

} // end of class
