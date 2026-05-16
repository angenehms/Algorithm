class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int standard = 1;
        int spec = 2*w + 1;

        
        for(int i=0; i<stations.length; i++) {
            
            int temp = stations[i];
            int now = (temp-w)-standard;
            
            if(now > 0) {
                answer += (now / spec);
                if(now % spec != 0) answer++;
            }
    
            standard = temp+w+1;
        }
        
        if(standard <= n) {
            int lastGap = n - standard + 1;
            answer += (lastGap / spec);
            if(lastGap % spec != 0) answer++;
        }
        

        return answer;
        
    } // end of main
} // end of class