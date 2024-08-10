import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt(); // 가로
        int height = sc.nextInt(); // 세로
        int cutTimes = sc.nextInt(); // 잘라야하는 횟수
        
        List<Integer> widthList = new ArrayList<>();
        List<Integer> heightList = new ArrayList<>();
        
        widthList.add(0); // 첫째항 추가
        heightList.add(0); // 첫째항 추가
        
        for (int i=0; i<cutTimes; i++) { // 세로, 가로 자르는 횟수 배열로 정리
            
            int firstInput = sc.nextInt(); // 세로인지, 가로인지 
            int secondInput = sc.nextInt(); // 어딜 자르는지
            
            if (firstInput == 0) {
                heightList.add(secondInput); // width 인지 height 인지 주의
            } else if (firstInput == 1) {
                widthList.add(secondInput); // width 인지 height 인지 주의
            }

        }
        
        Collections.sort(widthList);
        Collections.sort(heightList);

        widthList.add(width); // 마지막 항 추가
        heightList.add(height); // 마지막 항 추가

        int widthMaxGap = 0;
        int heigthMaxGap = 0;
        
        for(int i =0; i<widthList.size()-1; i++) { // 가로 중 최대 갭 구하기
        	int gap = Math.abs(widthList.get(i) - widthList.get(i+1)); // 가독성 위해
            if ( gap > widthMaxGap ) {
                widthMaxGap = Math.abs(widthList.get(i) - widthList.get(i+1));
            }
        }
        
        for(int i =0; i<heightList.size()-1; i++) { // 세로 중 최대 갭 구하기
        	int gap = Math.abs(heightList.get(i) - heightList.get(i+1)); // 가독성 위해
            if ( gap > heigthMaxGap ) {
                heigthMaxGap = Math.abs(heightList.get(i) - heightList.get(i+1));
            }
        }

        System.out.println(widthMaxGap*heigthMaxGap);

    }
}