import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map, visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new int[N][N];
		String s;
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int cnt = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 || visited[i][j] > 0) continue;
				visited[i][j] = cnt;
				dfs(i, j, cnt);
				cnt++;
			}
		}

		int[] ans = new int[cnt];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0) continue;
				ans[visited[i][j]]++;
			}
		}		

		Arrays.sort(ans);
		sb.append(cnt-1).append('\n');
		for(int i = 1; i < cnt; i++) {
			sb.append(ans[i]).append('\n');
		}
		
		System.out.println(sb.toString());
	}

	private static void dfs(int x, int y, int cnt) {
		
		for(int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(outOfRange(nx, ny) || map[nx][ny] == 0 || visited[nx][ny] > 0) continue;
			visited[nx][ny] = cnt;
			dfs(nx, ny, cnt);
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= N)
			return true;
		return false;
	}

}