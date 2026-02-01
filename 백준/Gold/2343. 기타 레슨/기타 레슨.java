import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static int[] arr;
	
	static int total = 0;
	static int result = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		int left = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp > left) left = temp;
			arr[i] = temp;
			total += temp;
		}
		
		int right = total;
		
		while(left <= right) {
			
			int capa = left + (right - left) / 2; // 블루레이 하나 용량
			
			int blue = 1; // 블루레이 갯수
			int accum = 0;
			
			for(int i=0; i<N; i++) {
				accum += arr[i];
				if(accum > capa) { // 케파 넘으면
					accum = 0;
					blue ++;
					i --;
				}
			}
			
			if(blue <= M) {
				
				result = capa;
				right = capa-1;
			
			} else {
				left = capa + 1;
			} 
			
		}
		
		System.out.println(result);
		
	} // end of main
	
} // end of class
