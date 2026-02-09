import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H;
	static int W;
	
//	static int[][] map;
	static int[] arr;
	
	static int highestIndex = 0;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		
//		map = new int[H][W];
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<W; i++) {
//			int temp = Integer.parseInt(st.nextToken());
//			arr[i] = temp;
//			for(int j=H-1; j>=H-temp; j--) {
//				map[j][i] = 1;
//			}
//		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		highestIndex = findMaxIndex();
		if(highestIndex == -1) { // 모두 높이가 0 일때
			System.out.println(0);
			return;
		}
		
		int leftStandard = findLeftFirstIndex();
		int rightStandard = findRightFirstIndex();
		
		if(leftStandard!=-1) { // 유의미한 기둥이 있어야
			
			for(int i=leftStandard; i<=highestIndex-1; i++) {
				
				int temp = arr[i];
				int redis = 0;
				
				for(int j=i+1; j<=highestIndex; j++) {
					if(arr[i] > arr[j]) {
						redis += (arr[i]-arr[j]);
					} else {
						result += redis;
						i = j-1;
						break;
					}
				} 
				
			}
			
		}
		
		if(rightStandard!=-1) { // 유의미한 기둥이 있어야
			
			for(int i=rightStandard; i>=highestIndex+1; i--) {
				
				int temp = arr[i];
				int redis = 0;
				
				for(int j=i-1; j>=highestIndex; j--) {
					if(arr[i] > arr[j]) {
						redis += (arr[i]-arr[j]);
					} else {
						result += redis;
						i = j+1;
						break;
					}
				} 
				
			}
			
		}
		
		System.out.println(result);
		
	} // end of main
	
	static int findRightFirstIndex() { // 왼쪽에서부터 볼때 가장 첫번째로 유의미한 인덱스가 나오는 경우 찾기
		for(int i=W-1; i>highestIndex; i--) {
			if(arr[i]==0) continue;
			return i;
		}
		return -1; // 다 0이면 -1 출력
	} // end findLeftFirst
	
	static int findLeftFirstIndex() { // 왼쪽에서부터 볼때 가장 첫번째로 유의미한 인덱스가 나오는 경우 찾기
		for(int i=0; i<highestIndex; i++) {
			if(arr[i]==0) continue;
			return i;
		}
		return -1; // 다 0이면 -1 출력
	} // end findLeftFirst
	
	static int findMaxIndex() { // 가장 높은 벽인덱스 찾기
		int max = 0;
		int index = -1;
		for(int i=0; i<W; i++) {
			if(max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	} // end of findMaxIndex
	
//	static void printMap() {
//		for(int i=0; i<H; i++) {
//			System.out.println();
//			for(int j=0; j<W; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//		}
//	} // end of printMap
	
} // end of class
