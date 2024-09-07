import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int key = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			if(Integer.parseInt(st.nextToken()) == key) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
