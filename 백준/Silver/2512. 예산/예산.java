import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] askList;
	static int total;
	
	static int askTotal = 0;
	static int maxInList = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 입력 받기
		N = Integer.parseInt(br.readLine());
		askList = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int ask = Integer.parseInt(st.nextToken());
			if(maxInList < ask) maxInList = ask;
			askList[i] = ask;
			askTotal += ask;
		}
		total = Integer.parseInt(br.readLine());
		
		if(total >= askTotal) {
			System.out.println(maxInList); 
			return;
		}
		
		int left = 1;
		while(left <= maxInList) {
			
			int mid = (left + maxInList) / 2;
			int value = totalSumWhenHigh(mid);
			
			if(value > total) { // 상한액 낮추기
				maxInList = mid-1;
			} else { // 상한액 높이기
				left = mid+1;
			}
			
		}
		
		System.out.println(maxInList);
		return;
		
	} // end of main
	
	static int totalSumWhenHigh(int high) {
		int result = 0;
		for(int i=0; i<N; i++) {
			result += Math.min(askList[i], high);
		}
		return result;
	} // end of totalSumWhenHigh
	
} // end of class
