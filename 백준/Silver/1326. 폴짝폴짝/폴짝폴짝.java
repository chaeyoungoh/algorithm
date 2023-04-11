import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int x, cnt;

		public Point(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	private static int bfs(int s, int e, int[] map, int n) {
		boolean[] visited = new boolean[n+1];
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(s, 0));
		visited[s] = true;
		
		while(!que.isEmpty()) {
			Point tmp = que.poll();
			int x = tmp.x;
			int cnt = tmp.cnt;
			int gap = map[tmp.x];
//			System.out.println("@@@@@@@@" + cnt + " " + x);
			if(x == e) {
				return cnt;
			}
			else {
				int next = x;
				while(true) {
					next += gap;
//						System.out.println(">>>>>" + next);
					if(next > n) break;
					if(visited[next]) continue;
					visited[next] = true;
					que.offer(new Point(next, cnt+1));
				}
				
				next = x;
				while(true) {
					next -= gap;
//						System.out.println(">>>>>" + next);
					if(next < 1) break;
					if(visited[next]) continue;
					visited[next] = true;
					que.offer(new Point(next, cnt+1));
				}
			}
		
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int ans = bfs(S, E, map, N);
		
		System.out.println(ans);
	}


}