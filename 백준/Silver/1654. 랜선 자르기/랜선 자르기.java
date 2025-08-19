import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int K;
	static int N;
	static int[] arr;
	static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		// 항상 K <= N
		arr = new int[K];
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} // arr 에 K 랜선 담기
		int max = 0;
		for(int i=0; i<K; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		binarySearch(1, max);
	} // end of main
	
	// 길이를 최대로 해서 N 개 이상 만들 수 있게 할때 최대의 센치미터 길이 구하기
	static void binarySearch(long start, long end) {
		while (start <= end) {
			long cnt = 0;
			long mid = start + (end - start) / 2;
			if (mid == 0) {
				result = 1;
				break;
			}
			for(int i=0; i<arr.length; i++) {
				cnt += arr[i] / mid;
			}
			
			if(cnt >= N) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid -1;
			}
		}
		System.out.println(result);
		
	} // end of binarySearch
} // end of class
