import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = 9;
		int[][] arr = new int[N][N];
		
		int max = 0;
		int rNum = 0;
		int cNum = 0;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[r][c] = temp;
				if (temp >= max) {
					max = temp;
					rNum = r+1;
					cNum = c+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(rNum + " " + cNum);
		
	}
}
