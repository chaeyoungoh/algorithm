import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static List<Integer> list;
	static int ans, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		list.add(0);
		for(int i=1; i<=N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		max = Integer.MIN_VALUE;
		ans = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			boolean[] visited = new boolean[N+1];
			visited[i] = true;
			dfs(i, i, 0, visited);
		}

		System.out.println(ans);
	}

	private static void dfs(int i, int s, int cnt, boolean[] visited) {
		int nx = list.get(i);
		if(visited[nx]) {
			if(cnt > max) {
				max = cnt;
				ans = s;
			} else if(cnt == max) {
				ans = Math.min(ans, s);
			}
			return;
		}
		visited[nx] = true;
		cnt++;
		dfs(nx, s, cnt, visited);
	}
}