import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 배열에 입력 박아넣기
		Character[][] arr = new Character[5][15];
		for(int r=0; r<5; r++) {
			String S = br.readLine();
			for(int c=0; c<S.length(); c++) {
				arr[r][c] = (Character) S.charAt(c);
			}
			for(int c=S.length(); c<15; c++) {
				arr[r][c] = null;
			}
		}
		
		for(int c=0; c<15; c++) {
			for(int r=0; r<5; r++) {
				if(arr[r][c] != null) {
					sb.append(arr[r][c]);
				}
			}
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class

