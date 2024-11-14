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
		int[] arr = new int[26];
		for(int i=0; i<S.length(); i++) {
			int alphaNum = S.charAt(i) - 0; // 알파벳을 숫자로
			if ( alphaNum > 90 ) { // 소문자면
				arr[alphaNum-97]++; // 'a' 의 아스키코드가 97
			} else { // 대문자면 
				arr[alphaNum-65]++;
			}
		}
				
		int max = 0;
		int maxIdx = 0;
		
		for(int i=0; i<26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				maxIdx = i;
			}
		}
		
		// max 여러개인지 cnt 로 2 이상인지 판단후 2 이상이면 ? 출력
		int cnt = 0;
		for(int i=0; i<26; i++) {
			if(arr[i] == max ) {
				cnt ++;
			}
			if(cnt >= 2 ) {
				System.out.println("?");
				return;
			}
		}
		System.out.println((char) (maxIdx+65));
	}
}
