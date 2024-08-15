import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		LinkedList<Integer> list;
		int N;
		int M;
		int X;
		int Y;
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			
			// 입력값 받기
			N = Integer.parseInt(br.readLine());
						
			list = new LinkedList<>();
			
			// 입력값을 list 에 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { 
				list.add(Integer.parseInt(st.nextToken()));						
			}
			
			M = Integer.parseInt(br.readLine());

			// 입력값에 따라 분기
			st = new StringTokenizer(br.readLine()); 
			for (int i = 0; i < M; i++) {				
				String method = st.nextToken(); 
				
				if(method.equals("I")) { // 삽입
					X = Integer.parseInt(st.nextToken()); // x번째 암호문 바로 다음에
					Y = Integer.parseInt(st.nextToken()); // y개 삽입
					for (int j = 0; j < Y; j++) {
						list.add(X+j ,Integer.parseInt(st.nextToken()));
					}		
				} else if(method.equals("D")) { // 삭제
					X = Integer.parseInt(st.nextToken()); // x번째 암호문 바로 다음부터 
					Y = Integer.parseInt(st.nextToken()); // y개의 암호문을 삭제
					for (int j = 0; j < Y; j++) {
						list.remove(X);
					}				
				} else if(method.equals("A")) { // 추가
					Y = Integer.parseInt(st.nextToken()); // 맨 뒤에 y개의 암호문을 덧붙이기
					for (int j = 0; j < Y; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}

			
			}

			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	} // end of main
} // end of class
