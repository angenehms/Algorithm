import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st; 
        
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            for(int i=0; i<arr.length; i++) {
                String str = br.readLine();
                for(int j=0; j<arr[0].length; j++) {
                    arr[i][j] = str.charAt(j) - '0'; // char 을 숫자로 변환하는 법 -> parseInt 는 안됨
                }
            }
            
            int sum = 0;
            
            // 중간라인 전까지 연산
            for(int i=0; i<N/2; i++) {
                for(int j=(N/2)-i; j<=(N/2)+i; j++) {
                    sum += arr[i][j];
                }
            }
            
            // 중간라인 연산
            for(int i=0; i<N; i++) {
                sum += arr[(N/2)][i];
            }
            
            // 중간라인 뒤에 연산
            int support = 1;
            for(int i=(N/2)+1; i<N; i++) {
                
                for(int j=support; j<N-support; j++) {
                    sum += arr[i][j];
                }
                support++;

            }
            
            
            sb.append("#").append(testCase).append(" ").append(sum).append("\n");
            
        } // end of tc
        System.out.println(sb);
		
		
	
	} // end of main

} // end of class
