import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x, y, lv;

		public Point(int x, int y, int lv) {
			super();
			this.x = x;
			this.y = y;
			this.lv = lv;
		}
	}
	

	private static int bfs(Point start, Point end, int n) {
		int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
		int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
		
		Queue<Point> que = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		
		que.offer(start);
		while(!que.isEmpty()) {
			Point cur = que.poll();
			int x = cur.x;
			int y = cur.y;
			int lv = cur.lv;
			visited[x][y] = true;
			if(x == end.x && y == end.y) {
				
				return lv;
			}
			
			for(int d=0; d<dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(outOfRange(nx, ny, n)) continue;
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				que.offer(new Point(nx, ny, lv+1));
			}
		}
		
		return -1;
	}

	private static boolean outOfRange(int nx, int ny, int n) {
		if(nx < 0 || nx >= n || ny < 0 || ny >= n)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc=0; tc<T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			Point start = new Point(s, e, 0);
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			Point end = new Point(s, e, 0);
				
			int cnt = bfs(start, end, N);
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}