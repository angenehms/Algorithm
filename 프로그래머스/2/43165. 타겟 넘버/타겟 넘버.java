import java.util.*;

class Solution {
    
    static int N;
    static int answer;

    public int solution(int[] numbers, int target) {

        N = numbers.length;
        dfs(0, 0, N, numbers, target, 0);
        
        return answer;
        
    } // end of solution
    
    static void dfs(int start, int idx, int N, int[] numbers, int target, int accum) {
        
        if(idx == N) {
            if(target == accum) {
                answer++;
            }
            return;   
        }
        
        for(int i=start; i<N; i++) {

            // 더할경우
            int plus = accum + numbers[i];
            dfs(i+1, idx+1, N, numbers, target, plus);
            
            int minus = accum - numbers[i];
            dfs(i+1, idx+1, N, numbers, target, minus);
        }
        
    } // end of dfs
    
} // end of class