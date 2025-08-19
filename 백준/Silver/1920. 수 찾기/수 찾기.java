import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		long[] secondArr = new long[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			secondArr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0; i<M; i++) {
			binarySearch(secondArr[i]);
		}
		System.out.println(sb);
	} // end of main
	
	static void binarySearch(long target) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(arr[mid] == target) {
				sb.append(1).append("\n");
				return;
			} else if (arr[mid] > target) {
				end = mid -1;
			} else if (arr[mid] < target) {
				start = mid + 1;
			}
		}
		sb.append(0).append("\n");
		return;
	}
} // end of class
