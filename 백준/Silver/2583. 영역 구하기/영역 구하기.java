import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int C, R, K, cnt;
	static boolean[][] map, visited;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		List<Integer> result = new ArrayList<>();
		
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] rows = new int[K][2];
		int[][] cols = new int[K][2];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			rows[i][0] = Integer.parseInt(st.nextToken());
			cols[i][0] = Integer.parseInt(st.nextToken());
			rows[i][1] = Integer.parseInt(st.nextToken());
			cols[i][1] = Integer.parseInt(st.nextToken());
		}
//		2.	직사각형 체크하기 
		map = new boolean[R+1][C+1];
		visited = new boolean[R+1][C+1];
		for(int i=0; i<K; i++) {
			int c1 = cols[i][0];
			int c2 = cols[i][1];
			int r1 = rows[i][0];
			int r2 = rows[i][1];	
			for(int r=r1; r<r2; r++) {
				for(int c=c1; c<c2; c++) {
					map[r][c] = true;
				}
			}
		}
		
//		3. 탐색
		for(int i=0; i<R; i++) {
			for(int j=0;j<C; j++) {
				if(map[i][j])		continue;
				if(visited[i][j])	continue;
				
				cnt = 0;
				dfs(i, j);
				if(cnt == 0)	
					result.add(1);
				else	
					result.add(cnt);
			}
		}
		sb.append(result.size()).append('\n');
		Collections.sort(result);
		for(int bound : result)
			sb.append(bound).append(' ');
		System.out.println(sb.toString());
	}

//	dfs : 4방탐색 
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	private static void dfs(int i, int j) {
		
		for(int d=0; d<dx.length; d++) {
			int ni = i + dx[d];
			int nj = j + dy[d];
			if(ni < 0 || nj < 0 || ni >= R || nj >= C)	continue;
			if(map[ni][nj])		continue;
			if(visited[ni][nj])	continue;
			visited[ni][nj] = true;
			cnt++;
			dfs(ni, nj);
		}
	}

}