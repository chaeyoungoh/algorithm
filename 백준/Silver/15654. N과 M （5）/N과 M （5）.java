import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] nums;
	static boolean[] visited;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);

		visited = new boolean[N];
		selected = new int[N];
		
		perm(0);
		
		System.out.println(sb.toString());	
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			printSelected();
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

	private static void printSelected() {
		for(int i=0; i<M; i++) 
			sb.append(nums[selected[i]]).append(' ');
		sb.append('\n');
	}

}