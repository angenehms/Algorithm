import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int temp;
		boolean[] cntArr = new boolean[42];
		for(int i=0; i<10; i++) {
			temp = Integer.parseInt(br.readLine());
			cntArr[temp%42] = true;
		}
		int cnt = 0;
		for(int i=0; i<42; i++) {
			if(cntArr[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	
	} // end of main

} // end of class
