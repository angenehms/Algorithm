import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] now = new int[n+2];
        Arrays.fill(now, 1);
        now[0] = 0;
        now[n+1] = 0;
        for(int ele : lost) {
            int temp = now[ele];
            now[ele] = temp-1;
        }
        for(int ele : reserve) {
            int temp = now[ele];
            now[ele] = temp+1;
        }
        
        for(int i=1; i<n+1; i++) {
            if(now[i] ==0) {
                
                if(now[i-1]==2) {
                    now[i]=1;
                    now[i-1]=1;
                } else if(now[i+1]==2) {
                    now[i]=1;
                    now[i+1]=1;
                }
                
            }
        }
        
        int result = 0;
        for(int i=1; i<n+1; i++) {
            if(now[i] >= 1) result++; 
        }
        
        System.out.println(Arrays.toString(now));
        return result;
        
        
    } // end of main
} // end of class