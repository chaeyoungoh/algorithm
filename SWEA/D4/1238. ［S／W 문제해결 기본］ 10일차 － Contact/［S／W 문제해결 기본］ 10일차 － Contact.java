import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	private static void bfs() {
		ArrayList<Integer> maxs = new ArrayList<>();
		boolean[] visited = new boolean[101];
		Queue<Integer> que = new LinkedList<>();
		que.offer(S);
		visited[S] = true;
		int lv = 0;
		while(!que.isEmpty()) {			
			int max = Integer.MIN_VALUE;
			int len = que.size();
			
			for(int i = 0; i < len; i++) {
				int tmp = que.poll();
				max = Math.max(max, tmp);
				
				for(int next : list.get(tmp)) {
					if(visited[next]) continue;
					visited[next] = true;
					que.offer(next);
				}
			}
			
			maxs.add(max);			
			lv++;
		}
		ans = maxs.get(lv - 1);
	}
	
	static int N, S, ans;
	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for(int i = 0; i < 101; i++) {
				list.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list.get(from).add(to);
			}
			
			bfs();
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb.toString());
	}

}