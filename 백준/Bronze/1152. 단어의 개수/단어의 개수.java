import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		LinkedList<String> list = new LinkedList<>();
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		System.out.println(list.size());
	
	} // end of main

} // end of class
