import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] arr;
	static int answerCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			int N = Integer.parseInt(br.readLine());
			
			// 2차원 배열 생성 => 각 원소들은 모두 서로다른 수
			// 1이상 N^2 이하의 수로 이루어짐, 즉 N=3 이면 1~9
			arr = new int [N][N];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] finalAnswerArr = new int [2]; // [arr[r][c], count]
						
			// 순회하면서 dfs 넣기 시작
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					answerCnt = 0;
					dfs(r, c);
					if ( answerCnt > finalAnswerArr[1] ) {			
						finalAnswerArr[0] = arr[r][c];
						finalAnswerArr[1] = answerCnt;
					} else if ( answerCnt == finalAnswerArr[1] && finalAnswerArr[0] > arr[r][c]) {
						finalAnswerArr[0] = arr[r][c];
					}
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(finalAnswerArr[0]).append(" ").append(finalAnswerArr[1]+1).append("\n");
	
		}
		System.out.println(sb);
	} // end of main
	
	public static void dfs (int r, int c) {
		
		int nr;
		int nc;


		for(int i=0; i<4; i++) {
			
			nr = r + dr[i];
			nc = c + dc[i];	
				
			try {
				
				if ( arr[r][c]+1 == arr[nr][nc] ) {
					answerCnt++;
					dfs(nr, nc);
				}
		
			} catch (Exception e) {}
			
		}

	}
} // end of class
