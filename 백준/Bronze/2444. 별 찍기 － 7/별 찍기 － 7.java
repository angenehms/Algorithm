import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// 위쪽
		for(int i=0; i<N-1; i++) {
			int blank = N-1-i;
			int star = 2*i+1;
			for(int j=0; j<blank; j++) {
				sb.append(" ");
			}
			for(int j=0; j<star; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		// 가운데
		for(int i =0; i<2*N-1; i++) {
			sb.append("*");
		}
		sb.append("\n");
		
		// 아래쪽
		for(int i=1; i<=N-1; i++) {
			int blank = i;
			int star = 2*(N-i) -1;
			for(int j=0; j<blank; j++) {
				sb.append(" ");
			}
			for(int j=0; j<star; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
