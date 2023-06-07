import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0)
					bfs(i, j);
				
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
	
		System.out.println(sb.toString());
	}

	private static void bfs(int s, int e) {
		boolean[] visited = new boolean[N];
		Queue<Integer> que = new LinkedList<>();
		que.offer(s);
		while(!que.isEmpty()) {
			int tmp = que.poll();
			for(int nx=0; nx<N; nx++) {
				if(visited[nx])	continue;
				if(map[tmp][nx] == 1) {
					if(nx == e) {
						map[s][e] = 1;
						return;
					}
					else {
						visited[nx] = true;
						que.offer(nx);
					}
				}
			}
		}
	}

}