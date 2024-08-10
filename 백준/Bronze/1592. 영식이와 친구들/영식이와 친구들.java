import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 한사람이 공 M번 받으면 끝남
		int L = Integer.parseInt(st.nextToken()); // 받은 횟수 M 미만 && 받은 횟수 홀수면 시계방향으로 L 번째, 짝수면 반시계방향 L번째
		List<Integer> list = new ArrayList<>();
		list.add(0,1); // 일단 1번(인덱스0) 사람 공 받고
		
		for(int i=1; i<N; i++) {
			list.add(0);
		}
		
		int turn = 0; // 인덱스값
		int answer = 0;
				
		while ( !list.contains(M) ) {
			
			int nowHave = list.get(turn);
			
			if ( nowHave % 2 != 0 && nowHave < M ) { // 홀수면 시계방향	
				turn += L;
				if ( turn > N-1) {
					turn = turn-N;
				}
				list.set(turn, list.get(turn)+1);
				answer++;
			} else if ( nowHave % 2 == 0 && nowHave < M ) { // 짝수면 반시계방향
				turn -= L;
				if ( turn < 0 ) {
					turn = N+turn;
				}
				list.set(turn, list.get(turn)+1);
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
