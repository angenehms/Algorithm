import java.util.*;

class Solution {
    
    static int answer = 1; 
    
    public int solution(int[][] scores) {
        
        int[] ho = scores[0];
        int hoSum = ho[0] + ho[1];
        
        // 근태 기준 내림차순 정렬 -> 그다음은 동료평가
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        
        // 인센티브 필터하고 완호 등수 계산
        int status = checkScores(scores, ho, hoSum);
        
        return status;
    }
    
    static int checkScores(int[][] scores, int[] ho, int hoSum) {
        
        int maxPeerScore = 0; // 동료평가 최댓값
        
        for (int[] score : scores) {
            
            // 현재 사원의 동료 평가 점수가 이전 최고 점수보다 낮으면 인센티브 못받음
            if (score[1] < maxPeerScore) {
                
                // 탈락자인데 그게 완호라면 -1
                if (score[0] == ho[0] && score[1] == ho[1]) {
                    return -1;
                }
                
                continue; // 인센티브 대상에서 제외되므로 continue
            }
            
            // 동료 평가 점수 최댓값 갱신
            maxPeerScore = Math.max(maxPeerScore, score[1]);
            
            // 완호보다 두 점수의 합이 큰 사람만 카운트하여 등수 계산
            if (score[0] + score[1] > hoSum) {
                answer++;
            }
        }
        
        return answer;
    }
}