import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
	
		for (int testCase=1; testCase<=T; testCase++) {
  
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
        
			int[][] map = new int[N+2*M][N+2*M];

			// 맵 그리기
			for(int r=M; r<N+M; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=M; c<N+M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// +자 모양
            int maxPlus = 0;
            int tempMaxPlus = 0;
			for(int r=M; r<N+M; r++) {
				for(int c=M; c<N+M; c++) {
					for(int m=1; m<M; m++) {
						tempMaxPlus += map[r][c-m] + map[r][c+m] + map[r-m][c] + map[r+m][c];
					}
					tempMaxPlus += map[r][c];
                    if (maxPlus < tempMaxPlus) maxPlus=tempMaxPlus;
                    tempMaxPlus = 0;
				}
			}
            
			// x자 모양
            int maxX = 0;
            int tempMaxX = 0;
			for(int r=M; r<N+M; r++  ) {
				for(int c=M; c<N+M; c++) {
					for(int m=1; m<M; m++) {
						tempMaxX += map[r-m][c-m] + map[r+m][c-m] + map[r-m][c+m] + map[r+m][c+m];
					}
					tempMaxX += map[r][c];
                    if (maxX < tempMaxX) maxX=tempMaxX;
                    tempMaxX=0;
				}
			}

          	int answer = Math.max(maxX, maxPlus);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);	
	}
}
