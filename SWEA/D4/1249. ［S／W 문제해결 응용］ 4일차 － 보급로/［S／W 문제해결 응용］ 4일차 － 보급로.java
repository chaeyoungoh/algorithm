import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	
	static class Point implements Comparable<Point> {
		int x, y, sum;

		public Point(int x, int y, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.sum, o.sum);
		}
		
	}
	
	static int N, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = -1;
			
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			bfs();
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
	
		System.out.println(sb.toString());
	}
	
	private static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		visited[0][0] = true;
		pq.offer(new Point(0, 0, 0));
		
		while(!pq.isEmpty()) {
		
			Point tmp = pq.poll();
			
			for(int d=0; d<dx.length; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];

				if(outOfRange(nx, ny) || visited[nx][ny]) continue;

				if(nx == N-1 && ny == N-1) {
					ans = tmp.sum + map[nx][ny];
					return;
				}
				visited[nx][ny] = true;
				pq.offer(new Point(nx, ny, tmp.sum + map[nx][ny]));
				
			}
		
		}
		
	}

	private static boolean outOfRange(int nx, int ny) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= N)
			return true;
		return false;
	}
}