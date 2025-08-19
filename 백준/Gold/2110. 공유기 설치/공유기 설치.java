import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int C;
	static int[] arr = new int[N];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// arr 배열에 넣기
		arr = new int[N]; // 여기 !!!
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); // 정렬 [1,2,4,8,9]
		
		// 거리 갭 최대, 최소 구하기
		int minGap = Integer.MAX_VALUE;
		int maxGap = Integer.MIN_VALUE;
		maxGap = arr[arr.length-1] - arr[0]; // 여기 !!!
		
		for(int i=0; i<arr.length-1; i++) {
			int former = arr[i];
			int latter = arr[i+1];
			int gap = latter - former; // 정렬했으므로
			
			if(minGap > gap) minGap = gap;
		}
		
		// 그럼 정답은 minGap ~ maxGap 범위에 있겠다
		binarySearch(minGap, maxGap);
		
	} // end of main
	
	static void binarySearch(int start, int end) {
		int result = 0;
		int mid = 0;
		while(start <= end) { // 갭 선택
			mid = start + (end - start) / 2; // 여기 !!!
			
			int installCnt = 1;
			int formerHouse = arr[0];
			int latterHouse;
			for(int i=1; i<arr.length; i++) {
				latterHouse = arr[i];
				if(latterHouse - formerHouse >= mid) {
					installCnt++;
					formerHouse = latterHouse;
				} 
			}
			
//			if(installCnt == C) 이 조건으로 하면 안된다! >= C 후보중에서 가장 큰걸 찾아야해서 !!
			if (installCnt >= C) { // 너무 많이 설치되었으니 간격을 넓힌다 // 여기 !!!
				result = mid;
				start = mid + 1;
			} else if (installCnt < C) { // 너무 적게 설치되었으니 간격을 좁힌다
				end = mid - 1;
			}
 		}
		System.out.println(result);
		
	} // end of binarySearch
	
} // end of class
