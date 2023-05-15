import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int MIN = Integer.MAX_VALUE;
	public static int MAX = Integer.MIN_VALUE;
	public static int[] operators = new int[4];
	public static int[] nums;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		operators = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
//		Backtracking
		dfs(nums[0], 1);
		
//		output
		System.out.println(MAX);
		System.out.println(MIN);
		
	}

	private static void dfs(int val, int idx) {
		if(idx == N) {
			MAX = Math.max(MAX, val);
			MIN = Math.min(MIN, val);
			return;
		}
		
		for(int i=0; i<4; i++) {
			
			if(operators[i] == 0) continue;
			
			operators[i]--;

			switch (i) {
			
			case 0: dfs(val + nums[idx], idx + 1);	break;
			case 1: dfs(val - nums[idx], idx + 1);	break;
			case 2: dfs(val * nums[idx], idx + 1); 	break;
			case 3: dfs(val / nums[idx], idx + 1); 	break;
			
			}
			
			operators[i]++;
		}
		
	}

}