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
	static int[] degree;
	static List<Integer>[] graph;
	static Deque<Integer> q;
	
	static int[] timeArr;
	static int[] resultTime;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		degree = new int[N+1];
		timeArr = new int[N+1];
		q = new ArrayDeque<>();
		
		// 그래프 초기화
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프 그리기와 진입차수 세팅
		for(int i=1; i<N+1; i++) {
//			if(i==1) q.add(i); // 왜냐면 문제에서 선행 관계에 있는 작업이 하나도 없는 작업이 반드시 하나 이상 존재한다했는데 1번 작업은 항상 그러하다고 함
			st = new StringTokenizer(br.readLine());
			timeArr[i] = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt; j++) {
				int from = Integer.parseInt(st.nextToken());
				graph[from].add(i);
				degree[i]++;
			}
		}
		
		resultTime = new int[N+1];
		
		// 진입차수가 0인 걸 큐에 add 하고 해당 노드의 시간 누적배열에 넣기
		for(int i=1; i<N+1; i++) {
			if(degree[i] == 0) q.add(i);
			resultTime[i] = timeArr[i];
		}
		
		topologicalSort();
		int result = 0;
		for(int temp : resultTime) {
			if(result < temp) result = temp;
		}
		System.out.println(result);
		
	} // end of main 
	
	static void topologicalSort() {
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int next : graph[curr]) {
				resultTime[next] = Math.max(resultTime[next], resultTime[curr] + timeArr[next]);
				degree[next]--;
				if(degree[next] == 0) {
					q.add(next);
				}
			}
		}
		
	} // end of topologicalSort
	
} // end of class
