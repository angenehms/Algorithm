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
		
		int N = Integer.parseInt(br.readLine());
		int[][] point = new int[N][2];
		
		// 좌표 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// x 좌표가 증가하는 순으로 정렬
		Arrays.sort(point, (a,b) -> {
			if(a[0] != b[0]) return a[0]-b[0]; // x 값이 서로 다르면
			return a[1]-b[1];
		});
		
		// 출력
		for(int i=0; i<N; i++) {
			sb.append(point[i][0]).append(" ").append(point[i][1]).append("\n");
		}
		
		System.out.println(sb);
		
	} // end of main
} // end of class
