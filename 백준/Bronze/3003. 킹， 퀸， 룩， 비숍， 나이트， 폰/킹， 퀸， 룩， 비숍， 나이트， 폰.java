import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] completeArr = {1, 1, 2, 2, 2, 8};
		int[] nowArr = new int[6];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			nowArr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<6; i++) {
			sb.append(completeArr[i] - nowArr[i]).append(" ");
		}
		System.out.println(sb);

	}
}
