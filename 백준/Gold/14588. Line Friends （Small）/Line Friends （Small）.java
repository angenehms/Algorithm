import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int Q;
	
	static class Line {
		int left;
		int right;
		Line(int left, int right) {
			this.left = left;
			this.right = right;
		}
	} // end of Line
	
	static Line[] lineInfo;
	static List<Integer>[] graph;
	
	static int[][] dist;
	static final int MAX = 987654321;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		// lineInfo 초기화
		lineInfo = new Line[N+1];

		// lineInfo 그리기 -> 인덱스넘버는 라인넘버
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			lineInfo[i] = new Line(left, right);
		}
		
		dist = new int[N+1][N+1];
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<N+1; j++) {
				dist[i][j] = MAX;
			}
		}
		
		// 그래프 그리기
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<N+1; j++) {
				Line former = lineInfo[i];
				Line latter = lineInfo[j];
				if(isFriend(former, latter)) {
					// 양방향 친구
					dist[i][j] = 1;
					dist[j][i] = 1;
				}
			}
		}
		
		fw();
		
		Q = Integer.parseInt(br.readLine());
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			if(dist[start][target] == MAX) {
				sb.append(-1).append("\n");
				continue;
			}
			sb.append(dist[start][target]).append("\n");
		}
		
		System.out.println(sb);
		
	} // end of main
	
	static void fw() {
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		
	} // end of fw
	
	static boolean isFriend(Line former, Line latter) {
		
		int formerLeft = former.left;
		int formerRight = former.right;
		int latterLeft = latter.left;
		int latterRight = latter.right;
		
		if(formerLeft <= latterLeft && formerRight >= latterLeft) return true;
		if(formerLeft <= latterRight && formerRight >= latterRight) return true;
		
		// 이 아래 조건 안써서 처음에 틀림
		if(latterLeft <= formerLeft && latterRight >= formerLeft) return true;
		if(latterLeft <= formerRight && latterRight >= formerRight)	return true;
			
		return false;
		
	} // end of isFriend
	
} // end of class
