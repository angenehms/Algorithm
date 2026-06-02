class Solution {
    
    public int[] solution(int n, int s) {
        
        int q = s/n; // 몫
        int r = s%n; // 나머지
        int[] answer;
        
        if(q == 0) { // 몫이 0 이면
            answer = new int[1];
            answer[0] = -1;
        } else { // 몫이 0이 아니면
            answer  = new int[n];
            for(int i=n-1; i>=0; i--) {
                if(r>0) { // 나머지가 양수
                    answer[i] = q+1;
                    r--;
                } else {
                    answer[i] = q;
                }
                
            }
            
        }
        
        return answer;
            
    } // end of main
    
} // end of class