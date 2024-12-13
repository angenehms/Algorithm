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
	
		String N = br.readLine();
		Integer[] arr = new Integer[N.length()];
		for(int i=0; i<N.length(); i++) {
			arr[i] = N.charAt(i) - '0';
		}
		
		Arrays.sort(arr, (a,b) -> b-a);
		for(int i=0; i<N.length(); i++) {
			System.out.print(arr[i]);
		}
		
	} // end of main

} // end of class
