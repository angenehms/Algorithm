import java.util.*;

class Solution {
    
    static PriorityQueue<Integer> pq;
    static int answer; // 분 단위가 아닌 4자리 정수형(예: 900, 1800)으로 최종 저장

    public String solution(int n, int t, int m, String[] timetable) {
        
        // 대기열 큐
        pq = new PriorityQueue<>();
        int length = timetable.length;
        for(int i=0; i<length; i++) {
            int toInt = Integer.parseInt(timetable[i].replace(":", ""));
            pq.add(toInt);
        }
        
        int startTime = 900;
        
        // 마지막 버스 상태를 기억하기 위한 변수들
        int lastCrew = 0;   // 마지막으로 버스에 탄 크루의 시각
        int acceptCount = 0; // 마지막 버스에 탄 인원 수
        
        outer : for(int i=0; i<n; i++) { // 각 셔틀마다
            acceptCount = 0; // 이번 버스 탑승 인원 초기화
            
            inner : for(int j=0; j<m; j++) { // 태울 수 있는 명수
                
                Integer curr = pq.poll(); // 비어있는데 int로 받으면 에러뜸. null포인트익셉션 -> 형변환 공부
                
                if(curr == null) { // 뽑았는데 pq가 비어있었다면?
                    // 대기자가 아예 없으므로 콘은 마지막 버스 시간(startTime)에 오면 됨!
                    // 단, 루프를 바로 깨지 말고 마지막 버스 시간까지 업데이트를 받아야 하므로 아래처럼 처리
                    acceptCount = 0; 
                    break inner; 
                }
                
                if(startTime < curr) { // 이미 출발한 시각이었다면?
                    pq.add(curr); // 뺐던 거 다시 pq에 넣기
                    break inner; // 다음 차 기다리기
                }
                
                // 버스에 무사히 탑승한 경우
                lastCrew = curr;
                acceptCount++;
            }
            
            // *** 60분 초과시 시간 업데이트 반영 완료! ***
            if (i < n - 1) {
                startTime = addTime(startTime, t);
            }
        }
        
        // 셔틀 순회가 모두 끝난 후 정답 계산 (마지막 버스 기준)
        if (acceptCount < m) {
            // 자리가 남았다면 -> 마지막 버스 출발 시각에 딱 맞춰 오면 됨
            answer = startTime;
        } else {
            // 자리가 꽉 찼다면 -> 마지막으로 탄 크루보다 1분 빨리 와서 새치기
            answer = subTime(lastCrew, 1);
        }
        
        // "HH:MM" 4자리 문자열 포맷으로 변환하여 리턴
        return String.format("%02d:%02d", answer / 100, answer % 100);
        
    } // end of solution
    
    // 시간을 더해주는 메서드 (예: 950 + 15 = 1005)
    static int addTime(int currentTime, int minutesToAdd) {
        int hour = currentTime / 100;
        int min = currentTime % 100;
        
        min += minutesToAdd;
        if (min >= 60) {
            hour += min / 60;
            min %= 60;
        }
        return hour * 100 + min;
    }
    
    // 시간을 빼주는 메서드 (예: 900 - 1 = 859)
    static int subTime(int currentTime, int minutesToSub) {
        int hour = currentTime / 100;
        int min = currentTime % 100;
        
        min -= minutesToSub;
        if (min < 0) {
            hour -= 1;
            min += 60;
        }
        return hour * 100 + min;
    }
} // end of class

// import java.util.*;

// class Solution {
    
//     static PriorityQueue<Integer> pq;
//     static int answer;

//     public String solution(int n, int t, int m, String[] timetable) {
        
//         // 대기열 큐
//         pq = new PriorityQueue<>();
//         int length = timetable.length;
//         for(int i=0; i<length; i++) {
//             int toInt = Integer.parseInt(timetable[i].replace(":", ""));
//             pq.add(toInt);
//         }
        
//         int startTime = 900;
        
//         outer : for(int i=0; i<n; i++) { // 각 셔틀마다
            
//             inner : for(int j=0; j<m; j++) { // 태울 수 있는 명수
                
//                 Integer curr = pq.poll(); // 비어있는데 int로 받으면 에러뜸. null포인트익셉션 -> 형변환 공부
                
//                 if(curr == null) { // 뽑았는데 pq가 비어있었다면?
//                     answer = 
//                     break outer;
//                 }
                
//                 if(startTime < curr) { // 이미 출발한 시각이었다면?
//                     pq.add(curr); // 뺐던 거 다시 pq에 넣기
//                     break inner; // 다음 차 기다리기
//                 }
                
                
//             }
            
//             startTime += t; // *** 근데 이거 시간이니까 60분 초과시 시간 업데이트 해야함! *** 일단 보류, 로직만 작성!
            
//         }
        
//         for(int i=0; i<m; i++) {
        
//         }
        
        
        
//     } // end of main
// } // end of clas