import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
//		2. DP
		int[] dp = new int[N+1];
		
//		3. 연속된 합 구하기 (max)
		int result = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
			result = Math.max(result, dp[i]);
		}

//		4. output
		System.out.println(result);
	}
}