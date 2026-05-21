import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 1. 진입 지점(시작점) 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        int answer = 1; // 첫 번째 차량이 있으므로 카메라는 최소 1대 시작
        int from = routes[0][0];
        int to = routes[0][1];
        
        // 2. 단 한 번만 순회 (O(N))
        for (int i = 1; i < routes.length; i++) {
            int nextFrom = routes[i][0];
            int nextTo = routes[i][1];
            
            // 정렬을 했기 때문에 nextFrom은 항상 기존 from보다 크거나 같습니다.
            // 따라서 다음 차량의 진입 지점이 현재 '공통 교집합의 끝(to)'보다 작거나 같다면 무조건 겹칩니다.
            if (nextFrom <= to) {
                // 질문자님의 아이디어대로 교집합 범위를 좁힙니다.
                from = Math.max(from, nextFrom);
                to = Math.min(to, nextTo);
            } else {
                // 겹치지 않는다면 새로운 카메라가 필요합니다.
                answer++;
                // 기준 구간을 새 차량으로 완전히 리셋합니다.
                from = nextFrom;
                to = nextTo;
            }
        }
        
        return answer;
    }
}