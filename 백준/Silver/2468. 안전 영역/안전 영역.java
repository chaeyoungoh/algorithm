import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int max = 1;		// answer
	public static int[] dr = {1, -1, 0, 0};
	public static int[] dc = {0, 0, 1, -1};
	public static boolean[][] visited;
	public static int cnt;							// 각 H 별로 안전구역 카운트
	public static int N;							
	public static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		int maxHeight = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > maxHeight)	maxHeight = map[i][j];
			}
		}
		

//		maxHeight '미만'만큼 반복문을 돌리기
		for(int h=1; h<maxHeight; h++) {
//			높이 이하는 잠기게 하기
			sink(h);
		}
		
		System.out.println(max);
	}

	private static void sink(int H) {
//		잠기는 곳(H 이하)은 -1로 바꾸기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] <= H)
					map[r][c] = -1;
			}
		}
				
//		안전구역 세기 (+ max 갱신)
		countSafeZone();
	}

//	DFS (4방 탐색)
	private static void countSafeZone() {	
		visited = new boolean[N][N];
		cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] < 0)	continue;	// 잠긴 곳이면 넘기고
				if(visited[r][c])	continue;	// 방문했던 곳이면 넘기고
				visited[r][c] = true;
				cnt++;
				dfs(r, c);
			}
		}
		
		max = Math.max(max, cnt);

	}

	private static void dfs(int r, int c) {
		for(int d=0; d<dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(outOfRange(nr, nc))	continue;
			if(visited[nr][nc])	continue;
			if(map[nr][nc] < 0)	continue;
			visited[nr][nc] = true;
			dfs(nr, nc);
		}		
	}

	private static boolean outOfRange(int nr, int nc) {
		if(nr < 0 || nr >= N || nc < 0 || nc >= N)
			return true;
		return false;
	}
	
}