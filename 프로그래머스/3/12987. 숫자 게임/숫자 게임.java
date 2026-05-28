import java.util.*;

class Solution {
    
    // 전역 변수 세팅
    static int bScore = 0;
    static boolean[] visited;
    static int notExistIndex = 0;
    
    public int solution(int[] A, int[] B) {
        
        // 변수 세팅
        int length = A.length;
        visited = new boolean[length];
        
        // 각 배열 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<length; i++) { // 정렬된 A 원소를 하나하나 순회하며
            
            int target = A[i];
            int idx = binarySearch(B, length, target); // 이분 탐색 결과를 변수에 담음
            
            // 이분 탐색으로 찾은 자리가 이미 방문한 곳이라면, 오른쪽으로 밀면서 빈자리 찾기
            while(idx < length && visited[idx]) {
                idx++;
            }
            
            if(idx != length) { // 매개변수 탐색 해보니 '되는 것 가장 작은 게' 존재하면? (length 가 반환된 건 없다는 뜻)
                
                visited[idx] = true; // 이긴 카드도 방문 처리 해줘야 중복 사용을 막습니다.
                bScore++;
                
            } else { // 아예 존재 안하면? -> 미방문 원소 중 가장 작은 것을 택한다
                
                if(!visited[notExistIndex]) { // 방문 안한 곳이면
                    visited[notExistIndex] = true;
                    notExistIndex++;
                } else { // 방문 한 곳이면
                    while(visited[notExistIndex]) { // 순회하면서 방문 안한곳 찾기
                        notExistIndex++;
                    }
                    visited[notExistIndex] = true;
                    notExistIndex++;
                }
                
            }
            
        }
        
        return bScore;
        
    } // end of main
    
    static int binarySearch(int[] B, int length, int target) {
        
        int start = 0;
        int end = length;
        
        while(start < end) {
            
            int mid = start + (end - start) / 2;
            if(target < B[mid]) {
                end = mid;
            } else { // B[mid] <= target
                start = mid+1;
            }

        }
        
        // 방문 했다면
        
        
        return end;
        
    } // end of binarySearch
    
} // end of clas