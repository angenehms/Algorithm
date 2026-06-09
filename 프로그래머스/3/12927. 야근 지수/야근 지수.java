import java.util.*;

class Solution {
    
    static PriorityQueue<Integer> pq;
        
    public long solution(int n, int[] works) {
        
        // 아이디어 : 평평하게 만들기
        
        pq = new PriorityQueue<>(Collections.reverseOrder()); // 큰 수부터 오도록
        
        for (int ele : works) {
            pq.add(ele);
        }
        
        for (int i = 0; i < n; i++) { // 남은 일수만큼 실행
            int max = pq.poll();
            if (max == 0) return 0; // 이미 0이면 야근 없음
            pq.add(max - 1);
        }
        
        long answer = 0;
        
        // 답구하기(제곱)
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work; // 형변환
        }
        
        return answer;
    }
}

// import java.util.*;
// class Solution {
//     public long solution(int n, int[] works) {
        
//         Arrays.sort(works);
        
//         int length = works.length;
//         int pointer = length-1;
//         int param = 1;
        
//         int temp = works[pointer] - works[pointer-1]; // 차이 1 4 7 9
//         for(int i=pointer; i>0; i--) {
            
//             int gap = works[i] - works[i-1];
//             if(gap==0) {
//                 param++;
//             } else {
//                 int temp = gap*param;
//                 param++;
//             }
            
//         }
  
        
        
//     } // end of main
// } // end of class