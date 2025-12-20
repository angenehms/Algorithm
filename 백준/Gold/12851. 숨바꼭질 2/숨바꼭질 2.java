import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static final int MAX = 100000;
	
	static int N;
	static int K;
	
	static int[] COST;
	
	static Deque<Integer> q;
	
	static int fastestTime;
	static int resultCnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		COST = new int[100001];
		Arrays.fill(COST, Integer.MAX_VALUE);
		q = new ArrayDeque<>();
		bfs(N);
		sb.append(fastestTime).append("\n").append(resultCnt).append("\n");
		System.out.println(sb);
		
	} // end of main
	
	static void bfs(int start) {
		
		q.add(start);
		COST[start] = 0;
		
		while(!q.isEmpty()) {
			
			int curr = q.poll();
			if(curr == K) {
				resultCnt++;
				fastestTime = COST[curr];
			}
			
			if(curr-1 >= 0 && COST[curr-1] >= COST[curr]+1) {
				q.add(curr-1);
				COST[curr-1] = COST[curr] + 1;
			}
			
			if(curr+1 <= MAX && COST[curr+1] >= COST[curr]+1) {
				q.add(curr+1);
				COST[curr+1] = COST[curr]+1;
			}
			
			
			if(2*curr <= MAX && COST[2*curr] >= COST[curr]+1) {
				q.add(2*curr);
				COST[2*curr] = COST[curr]+1;
			}
			
		}
		
		
	} // end of bfs
	
	
} // end of class
