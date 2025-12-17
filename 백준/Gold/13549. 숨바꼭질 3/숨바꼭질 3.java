import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int K;
	
	static int Max = 100000;
	
	static Deque<Integer> q;
	static int[] COST;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		q = new ArrayDeque<>();
		COST = new int[100001];
		Arrays.fill(COST, Integer.MAX_VALUE);
		
		bfs(N);
		
	} // end of main
	
	static void bfs(int start) {
		
		q.add(start);
		COST[start] = 0;
		
		while(!q.isEmpty()) {
			
			int curr = q.poll();
			if(curr == K) {
				System.out.println(COST[K]);
				return;
			}
			
			// 순간이동
			if(2*curr <= Max && COST[2*curr] > COST[curr]) {
				COST[2*curr] = COST[curr];
				q.addFirst(2*curr);
			}
			
			// 뒤로 한칸 가기
			if(curr-1 >= 0 && COST[curr-1] > COST[curr] + 1) {
				COST[curr-1] = COST[curr] + 1;
				q.addLast(curr-1);
			}
			
			// 앞으로 한칸 가기
			if(curr+1 <= Max && COST[curr+1] > COST[curr] + 1) {
				COST[curr+1] = COST[curr] + 1;
				q.addLast(curr+1);
			}
			
		}
		
		
	} // end of bfs
	
} // end of class
