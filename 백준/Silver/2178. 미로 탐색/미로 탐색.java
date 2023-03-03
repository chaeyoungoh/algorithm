import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		String s;
		for(int i = 1; i <= N; i++) {
			s = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
			}
		}
		
		bfs();
		
		System.out.println(ans);
		
	}

	private static void bfs() {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(1, 1));
		visited[1][1] = true;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int lv = 0;
		while(!que.isEmpty()) {
			lv++;
			int len = que.size();
			for(int i = 0; i < len; i++) {
				Point tmp = que.poll();
				if(tmp.x == N && tmp.y == M) {
					ans = lv;
					return;
				}
				for(int d = 0; d < dx.length; d++) {
					int nx = tmp.x + dx[d];
					int ny = tmp.y + dy[d];
					if(outOfRange(nx, ny) || map[nx][ny] == 0 || visited[nx][ny]) continue;
					visited[nx][ny] = true;
					que.offer(new Point(nx, ny));
				}
			}
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		if(nx < 1 || nx > N || ny < 1 || ny > M)
			return true;
		return false;
	}

}