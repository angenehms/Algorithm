import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        
        // 입출력 3종 세트 만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
        // 입력값 받기
		int student = Integer.parseInt(br.readLine());		
		st = new StringTokenizer(br.readLine());
        
        // 인덱스가 가변적으로 변할 것 같아 리스트가 적당하다고 판단
        List<Integer> list = new ArrayList<>(); 

		// 메인 로직
		for (int i=1; i<=student; i++) {
			int ticket = Integer.parseInt(st.nextToken());
			
			if (ticket == 0) { // 0번을 뽑았을 때 해당 학생은 리스트 맨뒤에 자리함
				list.add(i-1,i);
			} else { // 그 외의 번호를 뽑았을 때 해당 학생은 인덱스에 따라 가변적으로 자리함 
				list.add(i-1-ticket, i);
			}

		}
		
		for(int i=0; i<student; i++) {
			sb.append(list.get(i)).append(" ");
		};
		
		System.out.println(sb);
	}
}