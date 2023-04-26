import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int r, c, h;
		public Point(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		byte[][][] map = new byte[H][N][M];
		Queue<Point> que = new LinkedList<>();
		
		int unripe = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j][k] = (byte) tmp;
					if(map[i][j][k] == 1) {
						que.offer(new Point(j, k, i));
					} else if(map[i][j][k] == 0) {
						unripe++;
					}
				}
			}
		}
		
		int days = -1;
		if(unripe == 0) {
			days = 0;
		} else {
			days = bfs(que, days, map, N, M, H);
		}
		
		System.out.println(days);

	}

	private static int bfs(Queue<Point> que, int ans, byte[][][] map, int N, int M, int H) {
		int[] dr = {0, 0, 0, 0, 1, -1};
		int[] dc = {0, 0, 1, -1, 0, 0};
		int[] dh = {1, -1, 0, 0, 0, 0};
		
		boolean[][][] visited = new boolean[H][N][M];
		int len = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size; i++) {
				Point tmp = que.poll();

				int r = tmp.r;
				int c = tmp.c;
				int h = tmp.h;
				visited[h][r][c] = true;
				
				for(int d=0; d<dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					int nh = h + dh[d];
					if(outOfRange(nr, nc, nh, N, M, H)) continue;
					if(visited[nh][nr][nc]) continue;
					if(map[nh][nr][nc] == -1) continue;
					visited[nh][nr][nc] = true;
					map[nh][nr][nc] = 1;
					que.offer(new Point(nr, nc, nh));
				}
				
			}
			len++;
			if(!isUnripe(map, N, M, H))
				break;
		}
		
		if(isUnripe(map, N, M, H))
			return -1;
		return len;
	}

	private static boolean isUnripe(byte[][][] map, int N, int M, int H) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[i][j][k] == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean outOfRange(int nr, int nc, int nh, int N, int M, int H) {
		if(nr < 0 || nc < 0 || nh < 0 || nr >= N || nc >= M || nh >= H)
			return true;
		
		return false;
	}

}