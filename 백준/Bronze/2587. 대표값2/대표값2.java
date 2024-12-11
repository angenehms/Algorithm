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
		
		int[] arr = new int[5];
		int sum = 0;
		int avg = 0;
		int mid = 0;
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 평균 구하기
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		avg = sum / 5;
		
		// 중앙값 구하기
		Arrays.sort(arr);
		mid = arr[arr.length/2];
		
		// 출력
		System.out.println(avg);
		System.out.println(mid);
		
		
	} // end of main
	

} // end of class
