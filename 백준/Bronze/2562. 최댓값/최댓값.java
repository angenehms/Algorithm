import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int max = 0;
		int cnt = 0;
		for(int i=0; i<9; i++) {
			int temp = Integer.parseInt(br.readLine());
			if ( max < temp ) {
				max = temp;
				cnt=i+1;
			}
		}
		System.out.println(max);
		System.out.print(cnt);
	} // end of main

} // end of class
