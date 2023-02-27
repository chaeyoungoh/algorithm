import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * [문제 유형] BFS (Queue) > 최소 일수
 * 1차 시도 : 메모리 초과
 */
public class Main {
	
	static int N, M, level;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> que;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		que = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					que.offer(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
		
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					flag = true;
					break;
				}
			}
		}
		
		if(flag)
			System.out.println(-1);
		else
			System.out.println(level);
		
	}

	private static void bfs() {
		
		while(!que.isEmpty()) {
			int len = que.size();
			boolean flag = false;

			for(int i = 0; i < len; i++) {
				Point tmp = que.poll();
				
				for(int j=0; j<4; j++) {
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
				
					if(outOfRange(nx, ny) || visited[nx][ny] || map[nx][ny] == -1) continue;
					flag = true;
					map[nx][ny] = 1;
					visited[nx][ny] = true;
					que.offer(new Point(nx, ny));
				}
			}
			if(flag)
				level++;
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		
		if(nx < 0 || nx >= N || ny < 0 || ny >= M)
			return true;
		return false;
	}

}