import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static int search(char[][] map, Queue<Point> que) {
		int cnt = 0;
		
		int[] evenX = {-1, -1, 0, 1, 1, 0};
		int[] evenY = {-1, 0, 1, 0, -1, -1};
		
		int[] oddX = {-1, -1, 0, 1, 1, 0};
		int[] oddY = {0, 1, 1, 1, 0, -1};
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			int x = cur.r;
			int y = cur.c;
			int line = x % 2;
			for(int d=0; d<6; d++) {
				int nx, ny;
				if(line % 2 == 0) {
					nx = x + evenX[d];
					ny = y + evenY[d];
				} else {
					nx = x + oddX[d];
					ny = y + oddY[d];
				}
			
				if(outOfRange(nx, ny, map.length, map[0].length)) continue;				

				if(map[nx][ny] == '.') {
					cnt++;
				}
			}
			
		}
		
		return cnt;
	}
	
	private static boolean outOfRange(int nx, int ny, int N, int M) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= M)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		Queue<Point> que = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '#') 
					que.offer(new Point(i, j));
			}
		}
		int ans = search(map, que);
		System.out.println(ans);
	}

}