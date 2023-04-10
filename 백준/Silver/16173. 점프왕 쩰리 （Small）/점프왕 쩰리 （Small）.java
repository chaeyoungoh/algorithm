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
	
	private static boolean bfs(int n, int[][] map) {
		int[] dx = {0, 1};
		int[] dy = {1, 0};
		boolean[][] visited = new boolean[n][n];
		
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0));
		while(!que.isEmpty()) {
			Point tmp = que.poll();
			int size = map[tmp.x][tmp.y];
			for(int i=0; i<2; i++) {
				int nx = tmp.x + dx[i] * size;
				int ny = tmp.y + dy[i] * size;
				
				if(outOfRange(nx, ny, n) || visited[nx][ny]) continue;
				if(map[nx][ny] == -1) 
					return true;
				que.offer(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
		return false;
	}
	
	private static boolean outOfRange(int nr, int nc, int N) {
		if(nr < 0 || nr >= N || nc < 0 || nc >= N)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(bfs(N, map)) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}

}