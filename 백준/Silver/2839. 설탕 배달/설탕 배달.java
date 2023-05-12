import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N+1];
		
		Arrays.fill(dp, -1);
		dp[3] = 1;
		if(N >= 5)
			dp[5] = 1;
		for(int i=3; i<=N; i++) {
			if(dp[i-3] > 0)
				dp[i] = dp[i-3] +1;
			if(i > 5)
				if(dp[i-5] > 0)
					if(dp[i] > 0)
						dp[i] = Math.min(dp[i], dp[i-5]+1);
					else
						dp[i] = dp[i-5] + 1;
		}
		
		System.out.println(dp[N]);
		
	}

}