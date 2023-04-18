import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int answer = -1;
	
	private static void dfs(int s, int end, int cnt, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
		if(s == end) {
			answer = cnt;
			return;
		}
		
		for(int ns : list.get(s)) {
			if(visited[ns]) continue;
			visited[ns] = true;
			dfs(ns, end, cnt+1, list, visited);
		}
	}

	private static void bfs(int s, int e, ArrayList<ArrayList<Integer>> list, int N) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> que = new LinkedList<>();
		que.offer(s);
		visited[s] = true;
		
		int lv = 0;
		while(!que.isEmpty()) {
			int len = que.size();
			
			for(int i=0; i<len; i++) {
				int tmp = que.poll();
				if(tmp == e) {
					answer = lv;
					return;
				}
					
				for(int ns : list.get(tmp)) {
					if(visited[ns]) continue;
					visited[ns] = true;
					que.offer(ns);
				}
			}
			lv++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		// 사람 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<=N; i++)
			list.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list.get(s).add(e);
			list.get(e).add(s);
		}
		
//		boolean[] visited = new boolean[N+1];
//		dfs(p1, p2, 0, list, visited);
		
		bfs(p1, p2, list, N);
		
		System.out.println(answer);
	}

}