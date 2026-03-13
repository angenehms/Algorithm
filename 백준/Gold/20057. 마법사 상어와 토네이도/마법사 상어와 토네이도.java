import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N; // 홀수
	
	static int startR;
	static int startC;
	
	static int[][] map;
	
	// 좌하우상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	
	// 이동 정보
	static int direction = 0;
	static int moveAmount = 1;
	static int moveAmountAdjust = 0;
	
	// 밖으로 나간 모래의 양
	static int out = 0;
	
	// (1,1) 도달 시 true 반환
	static boolean isEnd = false;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		for(int r=1; r<N+1; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<N+1; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int start = ((N+1)/2);
		startR = start; 
		startC = start;
		
		while(!isEnd) { // (1,1) 도착할 때까지
			spinStart(direction, moveAmount);
			direction = (direction+1)%4;
			moveAmountAdjust = (moveAmountAdjust+1)%2;
			if(moveAmountAdjust == 0) moveAmount++;
		}
		
		System.out.println(out);
		
	} // end of main
	
	static void spinStart(int direction, int moveAmount) {
		
		for(int i=0; i<moveAmount; i++) {
			
			startR += dr[direction]; // y 위치
			startC += dc[direction]; // y 위치
			
			int startSand = map[startR][startC]; // y 모래양
			map[startR][startC] = 0; // y 에 있던 모래 없애기
			
			// 비율 정하기
			int ten = (int) Math.floor(startSand*0.1);
			int seven = (int) Math.floor(startSand*0.07);
			int five = (int) Math.floor(startSand*0.05);
			int two = (int) Math.floor(startSand*0.02);
			int one = (int) Math.floor(startSand*0.01);
			
			int rest = startSand - (ten*2+seven*2+five+two*2+one*2);
			
			// 편의상 좌 기준 (dr dc 는 좌하우상 순)
			int left_R = dr[direction]; int left_C = dc[direction]; // 좌
			int down_R = dr[(direction+1)%4]; int down_C = dc[(direction+1)%4]; // 하
			int right_R = dr[(direction+2)%4]; int right_C = dc[(direction+2)%4]; // 우
			int up_R = dr[(direction+3)%4]; int up_C = dc[(direction+3)%4]; // 상
			
			int leftLeft_R = startR + left_R*2; int leftLeft_C = startC + left_C*2; // 좌좌
			int downDown_R = startR + down_R*2; int downDown_C = startC + down_C*2; // 하하
			int upUp_R = startR + up_R*2; int upUp_C = startC + up_C*2; // 상상

			int leftDown_R = startR + left_R + down_R; int leftDown_C = startC + left_C + down_C; // 좌하
			int leftUp_R = startR + left_R + up_R; int leftUp_C = startC + left_C + up_C; // 좌상
			
			int rightDown_R = startR + right_R + down_R; int rightDown_C = startC + right_C + down_C; // 우하
			int rightUp_R = startR + right_R + up_R; int rightUp_C = startC + right_C + up_C; // 우상
			
			if(!checker(startR + left_R, startC + left_C)) {
				out += rest;
			} else {
				map[startR + left_R][startC + left_C] += rest; // 좌
			}
			
			if(!checker(leftLeft_R, leftLeft_C)) {
				out += five;
			} else {
				map[leftLeft_R][leftLeft_C] += five; // 좌좌
			}
			
			if(!checker(leftUp_R, leftUp_C)) {
				out += ten;
			} else {
				map[leftUp_R][leftUp_C] += ten; // 좌상
			}
			
			if(!checker(leftDown_R, leftDown_C)) {
				out += ten;
			} else {
				map[leftDown_R][leftDown_C] += ten; // 좌하
			}
			
			if(!checker(startR + up_R, startC + up_C)) {
				out += seven;
			} else {
				map[startR + up_R][startC + up_C] += seven; // 상
			}
			
			if(!checker(upUp_R, upUp_C)) {
				out += two;
			} else {
				map[upUp_R][upUp_C] += two; // 상상
			}
			
			if(!checker(startR + down_R, startC + down_C)) {
				out += seven;
			} else {
				map[startR + down_R][startC + down_C] += seven; // 하
			}
			
			if(!checker(downDown_R, downDown_C)) {
				out += two;
			} else {
				map[downDown_R][downDown_C] += two; // 하하
			}
			
			if(!checker(rightUp_R, rightUp_C)) {
				out += one;
			} else {
				map[rightUp_R][rightUp_C] += one; // 우상
			}
			
			if(!checker(rightDown_R, rightDown_C)) {
				out += one;
			} else {
				map[rightDown_R][rightDown_C] += one; // 우하
			}
			
			// (1,1) 이면 true -> 토네이도 소멸 !!
			if(startR==1 && startC==1) {
				isEnd = true;
				return;
			}
			
		}
		
	} // end of spin
	
	static boolean checker(int nr, int nc) {
		return 1<=nr && nr<=N && 1<=nc && nc<=N;
	} // end of checker
	
} // end of class
