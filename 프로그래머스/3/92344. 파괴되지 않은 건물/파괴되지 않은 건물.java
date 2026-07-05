class Solution {
    
    static int[][] acc;
    static int answer;

    public int solution(int[][] board, int[][] skill) {
        
        int n = board.length;
        int m = board[0].length;
        
        acc = new int[n+1][m+1];
        
        for(int i=0; i<skill.length; i++) {
            
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if(type == 1) { // 적의 공격
                
                acc[r1][c1] -= degree;
                acc[r1][c2+1] += degree;
                acc[r2+1][c1] += degree;
                acc[r2+1][c2+1] -= degree;
                
            } else { // 아군의 회복
                
                acc[r1][c1] += degree;
                acc[r1][c2+1] -= degree;
                acc[r2+1][c1] -= degree;
                acc[r2+1][c2+1] += degree;
                
            }
            
        } 
        
        // 가로 누적합
        for(int r=0; r<=n ; r++) {
            for(int c=1; c<=m; c++) {
                acc[r][c] += acc[r][c-1];
            }
        }
        
        // 세로 누적합
        for(int c=0; c<=m; c++) {
            for(int r=1; r<=n; r++) {
                acc[r][c] += acc[r-1][c];
            }
        }
        
        // 반영
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(acc[r][c] + board[r][c] > 0) answer++;
            }
        }
        
        return answer;
        
    } // end of main
   
    
    
    
} // end of class