import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		// 산성 1 ~ 10억
		// 알칼리 -1 ~ -10억
		
		// 두 용액 합해서 0에 가장 가까운 용액을 만들려 함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		
		int resultL = 0;
		int resultR = 0;
		
		int closest = Integer.MAX_VALUE;
		
		while(left < right) {
			
			int sum = arr[left] + arr[right];
			int temp = Math.abs(sum);
			
			if(closest > temp) {
				closest = temp;
				resultL = left;
				resultR = right;
			}
			
			if(closest == 0) break;
		
			if(sum>0) {
				right--;
			} else {
				left++;
			}
			
		}
		

		System.out.println(arr[resultL] + " " + arr[resultR]);
	
		
	} // end of main
	
} // end of class
