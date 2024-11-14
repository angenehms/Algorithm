import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		
		// A 행렬 만들기
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// B 행렬 만들기
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				B[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 두 행렬 더하기 ( A 행렬에 덮어씌움 ) & 출력 한번에
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				sb.append(A[r][c] + B[r][c]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	} // end of main
} // end of class
