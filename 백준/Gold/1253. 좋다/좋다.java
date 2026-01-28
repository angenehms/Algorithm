import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long[] arr;
	static int resultCnt=0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			
			long standard = arr[i]; // 타겟값
			int left = 0;
			int right = arr.length - 1;
			
			while(left < right) {
				
				if(i == left) {
					left++;
					continue;
				}
				
				if(i == right) {
					right--;	
					continue;
				}
				
				long sum = arr[left] + arr[right];
				
				if(sum == standard) {
					resultCnt++;
					
//					if(arr[left] == arr[left+1]) {
//						left++;
//					} else if(arr[right] == arr[right-1]) {
//						right--;
//					} else {
						break;
//					}
					
				} else if(sum > standard) {
					right--;
				} else {
					left++;
				}
					
			}
		}
		
		System.out.println(resultCnt);
		
	} // end of main
	
} // end of class
