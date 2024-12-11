import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
 		}
		
//		// 버블 정렬
//		for(int i=N-1; i>0; i--) {
//			for(int j=0; j<i; j++) {
//				if(arr[j] > arr[j+1]) {
//					swap(j, j+1);
//				}
//			}
//		}
		
		Arrays.sort(arr);
		
		// 출력
		for(int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
		
		
	} // end of main
	
	
	static void swap(int idx, int idx2) {
		int temp = arr[idx];
		arr[idx] = arr[idx2];
		arr[idx2] = temp;
	}

} // end of class
