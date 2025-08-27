import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int r;
		int c; 
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	} // end of Node
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] answerMap;
	
	// 상하좌우
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static int nr;
	static int nc;
	
	static Deque<Node> q;
	static int startNodeR;
	static int startNodeC;
	
	static Map<Integer, Integer> hashMap;
	static Set<Integer> hashSet;
	static int areaKey;
	static int areaSquare; // 영역의 넓이
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// map 초기화 및 map 그리기
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		answerMap = new int[N][M];
		hashMap = new HashMap<>();
		areaKey = 2; // 주어진 맵에선 0 과 1 이 있으므로 2 부터 시작
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) {
					q = new ArrayDeque<>();
					areaSquare = 0;
					bfs(new Node(r, c)); // 값이 0 인 부분의 노드
					hashMap.put(areaKey, areaSquare);
					areaKey++;
				}
			}
		}
		
//		while(!isEnd(map)) { // 끝날 떄 까지, 즉 map 에 0이 없을 떄 까지, 남은 영역의 넓이 저장하기
//			q = new ArrayDeque<>();
//			areaSquare = 0;
//			bfs(new Node(startNodeR, startNodeC)); // 값이 0 인 부분의 노드
//			hashMap.put(areaKey, areaSquare);
//			areaKey++;
//		}
		
		for(int r=0; r<N; r++ ) {
			for(int c=0; c<M; c++) {
				if(map[r][c] > 1) {
					answerMap[r][c] = 0;
				} else {
					hashSet = new HashSet<>();
					cal(new Node(r,c));
				}
			}
		}
		
		makeSb(answerMap);
		System.out.print(sb);
		
	} // end of main
	
	static void cal(Node curr) {
		int sum = 1;
		for(int i=0; i<4; i++) {
			nr = curr.r + dr[i];
			nc = curr.c + dc[i];
			if(!checker()) continue;
			if(map[nr][nc] > 1) {
				hashSet.add(map[nr][nc]);
			}
		}
		for(int num : hashSet) {
			sum += hashMap.get(num);
		}
		answerMap[curr.r][curr.c] = sum % 10;
	} // end of cal
	
	static void bfs(Node node) {
		q.add(new Node(node.r, node.c));
		map[node.r][node.c] = areaKey;
		areaSquare++;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int i=0; i<4; i++) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(!checker()) continue;
				if(map[nr][nc] == 0) {
					q.add(new Node(nr,nc));
					map[nr][nc] = areaKey;
					areaSquare++;
				}
			}
		}
	} // end of bfs
	
	static boolean isEnd(int[][] map) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) {
					startNodeR = r;
					startNodeC = c;
					return false;
				}
			}
		}
		return true;
	} // end of isEnd
	
	static boolean checker() {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	} // end of checker
	
	static void makeSb(int[][] map) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
	} // end of printMap
	
} // end of class
