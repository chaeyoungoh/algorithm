import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, min;
	static int[][] map;
	static int[] selected;
	static boolean[] visited;
	
	private static void perm(int cnt) {
		if(cnt == N) {
			calc();
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[cnt] = i;
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	private static void calc() {
		int sum = 0;
		int s=0, e=0, cost=0;
		for(int i=0; i<N-1; i++) {
			s = selected[i];
			e = selected[i+1];
			cost = map[s][e];
			
			if(cost == 0) return;
			
			sum += cost;
			
			if(sum > min) return;
		}
		cost = map[e][selected[0]];
		if(cost == 0) return;
		
		sum += cost;
		min = Math.min(min, sum);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		selected = new int[N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		
		System.out.println(min);
	}

}