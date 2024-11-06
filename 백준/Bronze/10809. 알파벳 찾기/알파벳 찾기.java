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
		
		String S = br.readLine();
		char[] arr = new char[S.length()];
		int[] alphaArr = new int[26];
		int[] result = new int[26];
		for(int i=0; i<26 ;i++) {
			result[i] = -1;
		}
		for(int i=0; i<S.length(); i++) {
			arr[i] = S.charAt(i);
		}
		for(int i=97; i<=122; i++) {
			alphaArr[i-97] = i;
		}
		for(int i=0; i<S.length(); i++) {
			for(int j=0; j<26; j++) {
				
				if(arr[i]-0 == alphaArr[j]) {
					if(result[j] == -1) {
						result[j] = i;						
					}
					break;
				}

			}
			
			
		}
		for(int i=0; i<26; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
		
	} // end of main

} // end of class
