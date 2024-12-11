import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> arr = new LinkedList<>();
		
		// arr 에 입력 데이터 넣기
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		// arr 순회하며 계속 최솟값 앞으로 보내기
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if (arr.get(j) > arr.get(j+1)) {
					swap(arr, j, j+1);
				}
			}
		}
		
		// 중복제거
		for(int i=0; i<arr.size()-1; i++) {
			if(arr.get(i) == arr.get(i+1)) {
				arr.remove(i+1);
			}
		}
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
	
	} // end of main
	
	static void swap(LinkedList<Integer> arr, int idx, int idx2) {
		int temp = arr.get(idx);
		arr.set(idx, arr.get(idx2));
		arr.set(idx2, temp);
	}

} // end of class
