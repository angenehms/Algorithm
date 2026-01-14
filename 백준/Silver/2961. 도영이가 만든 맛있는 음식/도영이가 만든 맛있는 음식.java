import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static class Ingredient {
		int sour;
		int bitter;
		Ingredient(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	} // end of Ingredient
	
	static Ingredient[] list;
	static boolean[] visited;
	static Ingredient[] selected;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 재료 N개
		list = new Ingredient[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); // 신맛 -> 곱
			int B = Integer.parseInt(st.nextToken()); // 쓴맛 -> 합	
			list[i] = new Ingredient(S, B);
		}
		
		for(int i=1; i<=N; i++) {
			
			selected = new Ingredient[i];
			part(0, 0, i);
			
		}
		
		System.out.println(min);
		
		
	} // end of main
	
	static void part(int start, int idx, int m) {
		
		if(idx == m) {
			
			int tempSour = selected[0].sour;
			int tempBitter = selected[0].bitter;
			
			for(int j=1; j<m; j++) {
				tempSour *= selected[j].sour;
				tempBitter += selected[j].bitter;
			}
			
			int gap = Math.abs(tempSour-tempBitter);
			if(min > gap) min = gap;
			
			return;
		}
		
		for(int i=start; i<N; i++) {
			
			if(!visited[i]) {
				visited[i] = true;
				selected[idx] = list[i]; 
				part(i+1, idx+1, m);
				visited[i] = false;
			}
			
		}
		
	} // end of comb
	
} // end of class
