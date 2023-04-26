import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, L, R, sum;
	static int[][] A;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static ArrayList<Point> list;
	
	static class Point {
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static int move() {
		int ans = 0;
		while(true) {
			boolean flag = false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					list = new ArrayList<>();
					visited[i][j] = true;
					sum = A[i][j];
					dfs(i, j);

					if(list.size() > 1) {
						flag = true;
						arrangePopul();
					}
				}
			}
			if(!flag)	return ans;
			ans++;
		}
		
	}

	private static void dfs(int i, int j) {
		list.add(new Point(i, j));
		
		for(int d=0; d<dx.length; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(outOfRange(nx, ny)) continue;
			if(visited[nx][ny]) continue;
			if(outOfGap(i, j, nx, ny)) continue;
			visited[nx][ny] = true;
			sum += A[nx][ny];
			dfs(nx, ny);
		}

	}

	private static boolean outOfGap(int i, int j, int nx, int ny) {
		int gap = Math.abs(A[i][j] - A[nx][ny]);
		if(gap < L || gap > R) 
			return true;
		return false;
	}


	private static void arrangePopul() {
		int avgPopul = sum / list.size();
		for(Point tmp : list) {
			A[tmp.r][tmp.c] = avgPopul;
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= N)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
				
		int ans = move();
		
		System.out.println(ans);
	}

}