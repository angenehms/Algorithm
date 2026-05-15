import java.util.*;

class Solution {
    
    static class Node {
        String referralName;
        int accumIncome;
        Node(String referralName, int accumIncome) {
            this.referralName = referralName;
            this.accumIncome = accumIncome;
        }
    } // end of Node 
    
    static Map<String, Node> map = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int eN = enroll.length; // 이 길이는 referral 과 result 길이와 동일
        int[] result = new int[eN];
        
        // seller 과 amount 의 길이도 서로 같음
        int sN = seller.length;
        
        for(int i=0; i<eN; i++) {
            Node node = new Node(referral[i], 0);
            map.put(enroll[i], node);
        }
        
        for(int i=0; i<sN; i++) {
            
            String nowSeller = seller[i]; // 지금 판매자
            int nowSellerIncome = amount[i]*100; // 지금 막 수익난거
            
            dfs(nowSeller, nowSellerIncome);
        
        }
        
        for(int i=0; i<eN; i++) {
            Node temp = map.get(enroll[i]);
            result[i] = temp.accumIncome;
        }
        
        return result;

    } // end of main
    
    static void dfs(String nowSeller, int nowSellerIncome) {
        
        // Node
        Node nowNode = map.get(nowSeller); // nowSeller의 노드 찾기
        String nowParent = nowNode.referralName; // nowSeller의 부모
        int nowSellerAccumIncome = nowNode.accumIncome; // nowSeller의 여태 누적 수익
        
        int tenPercnetNowSellerIncome = nowSellerIncome/10; // 원단위절사 및 이익의 10%
        int nintyPercnetNowSellerIncome = nowSellerIncome - tenPercnetNowSellerIncome; // 이익의 90%
        if(tenPercnetNowSellerIncome<1) { // 1 미만이거나 자기가 그돈 갖기
            int adjustIncome = nowSellerAccumIncome + nowSellerIncome;
            map.put(nowSeller, new Node(nowParent, adjustIncome)); // 갱신
            return; 
        }
        
        if(nowParent.equals("-")) { // 부모가 센터("-")면 90% 만 갖기
            int adjustIncome = nowSellerAccumIncome + nintyPercnetNowSellerIncome;
            map.put(nowSeller, new Node(nowParent, adjustIncome)); // 갱신
            return; 
        }
        
        // 부모가 있고 1 이상이면
        map.put(nowSeller, new Node(nowParent, nowSellerAccumIncome + nintyPercnetNowSellerIncome)); // 내꺼에서 이익금의 10% 빼기
        dfs(nowParent, tenPercnetNowSellerIncome); // 부모에게 이익금의 10% 주기
            
    } // end of dfs
    
    
} // end of class