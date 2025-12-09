import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 최소공배수 = 두수의곱/최대공약수
	
	static int testCase;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();                                             
		StringTokenizer st;
		
		testCase = Integer.parseInt(br.readLine());
		for(int t=0; t<testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int former = Integer.parseInt(st.nextToken());
			int latter = Integer.parseInt(st.nextToken());
			long result = getLCM(former, latter);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
	} // end of main
	
	static int getGCD(int a, int b) {
		
		a = Math.abs(a);
		b = Math.abs(b);
		
		while(b!=0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		
		return a;
		
	} // end of getGCD
	
	static long getLCM(int a, int b) {
		
		if(a == 0 || b== 0) return 0;
		
		long product = (long) Math.abs(a) * Math.abs(b); 
		return product / getGCD(a,b);
		
	} // end of getLCM
	
	
	
} // end of class
