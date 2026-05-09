class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] result = new int[2];
        
        out : for(int yWidth=1; yWidth<=yellow; yWidth++) { // 논리적으로 길이의 최대는 yellow 수를 넘지 않을 것이므로
            for(int yHeight=1; yHeight<=yWidth; yHeight++) { // 가로는 세로와 같거나 길다

                int temp = (2*yWidth) + (2*yHeight) + 4;
                
                if(temp==brown) {
                    
                    if(yWidth*yHeight==yellow) {
                        result[0] = yWidth+2;
                        result[1] = yHeight+2;
                        break out;
                    }
                    
                }
                
            }
        }
        
        return result;
        
        
        
    } // end of main
} // end of class