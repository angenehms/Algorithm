import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 21 넘지 않는 한도 내에서 카드 최대합 구하는 게임
		// 정인 상근 창영
		// 정인 : 각 카드 양의 정수, N 장의 카드를 숫자 보이게 바닥에 놓고 딜러가 숫자 M 을 외침
		// 플레이어는 제한된 시간안에 N 장 중 3개 고르기
		// 플레이어가 고른 카드합은 M 넘지말고 M과 최대한 가깝게

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i =0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					if( temp > max && temp <= M ) {
						max = temp;
					}
				}
			}
		}
		System.out.println(max);
	}
}
