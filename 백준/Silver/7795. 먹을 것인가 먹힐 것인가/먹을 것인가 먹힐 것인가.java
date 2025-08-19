import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int result;
	static Integer[] A;
	static Integer[] B;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new Integer[N];
			B = new Integer[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A, Collections.reverseOrder()); // 내림차순 정렬
			Arrays.sort(B); // 오름차순 정렬
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(A[i] > B[j]) {
						result++;
					} else {
						break;
					}
				}
			}
			
			sb.append(result).append("\n");
			
		} // end of tc
		
		System.out.println(sb);
		
	} // end of main
	
	static void binarySearch() {
		int start = 0;
		int end = A.length-1;
		
		while (start <= end) {
			
		}
		
		return;
	}
	
} // end of class
