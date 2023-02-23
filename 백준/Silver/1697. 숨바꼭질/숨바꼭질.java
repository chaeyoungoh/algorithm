import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* dfs	(x) bfs	(o)
 * o, x
 */
public class Main {

	static int N, K, level;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		if(N == K) 
			System.out.println("0");
		else {	
			bfs();
			System.out.println(level);
		}
	}

	private static void bfs() {
		int[] dx = {-1, 1, 2};
		Queue<Integer> que = new LinkedList<>();
		que.offer(N);
		visited[N] = true;
		level = 0;
		
		while(!que.isEmpty()) {
			int len = que.size();
			level++;
			for(int i = 0; i < len; i++) {
				int tmp = que.poll();
//				if(tmp == K) 
//					return;
				for(int j = 0; j < 3; j++) {
					int nx = tmp;
					if(j == 2) 
						nx *= 2;
					else
						nx += dx[j];
			
					if(nx >= 0 && nx <= 100000 && !visited[nx]) {
						if(nx == K) return;
						visited[nx] = true;
						que.offer(nx);
					}
				}
			}
//			level++;
		}
			
	}

}