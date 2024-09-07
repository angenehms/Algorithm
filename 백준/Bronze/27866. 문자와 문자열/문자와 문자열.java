import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String S = br.readLine();
		int i = Integer.parseInt(br.readLine());
		
		System.out.println(S.charAt(i-1));
	
	} // end of main

} // end of class
