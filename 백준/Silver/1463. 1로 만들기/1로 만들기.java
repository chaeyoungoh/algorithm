import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(makeOne(N));
	}

	private static int makeOne(int n) {
		if(n == 1)
			return 0;
		
		int[] dp = new int[n+1];
		for(int i=2;i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if(i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}
		return dp[n];
	}

}