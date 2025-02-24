import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int second = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		System.out.println(first > second ? first : second);
		
		
	} // end of main

} // end of class
