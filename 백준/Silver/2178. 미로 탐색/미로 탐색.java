import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
				
//		2. bfs
//		3. output
		System.out.println(bfs(map, N, M));
		
		
		
	}

	static class Point {
		int x, y, cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	private static int bfs(int[][] map, int N, int M) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		boolean[][] ch = new boolean[N][M];
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0, 1));
		ch[0][0] = true;
		
		while(!que.isEmpty()) {
			Point tmp = que.poll();
			int x = tmp.x;
			int y = tmp.y;
			int cnt = tmp.cnt;
			if(isGoal(x, y, N, M))	return cnt;

			for(int d=0; d<dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(outOfRange(nx, ny, N, M))	continue;
				if(ch[nx][ny])	continue;
				if(map[nx][ny] == 0)	continue;
				que.offer(new Point(nx, ny, cnt+1));
				ch[nx][ny] = true;				
			}
			
		}
		
		return -1;
		
	}

	private static boolean isGoal(int nx, int ny, int N, int M) {
		if(nx == N-1 && ny == M-1)
			return true;
		return false;
	}

	private static boolean outOfRange(int nx, int ny, int N, int M) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= M)
			return true;
		return false;
	}

}