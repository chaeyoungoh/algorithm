import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] vals = new int[2][N];
			StringTokenizer st;
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					vals[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[2][N];
			dp[0][0] = vals[0][0];
			dp[1][0] = vals[1][0];
			if(N > 1)
				dp = makeDp(dp, vals, N);

			int max = Math.max(dp[0][N-1], dp[1][N-1]);
			
			sb.append(max).append('\n');
		}

		System.out.println(sb.toString());
	}

	private static int[][] makeDp(int[][] dp, int[][] vals, int N) {
		for(int c=1; c<N; c++) {
			dp[0][c] = dp[1][c-1] + vals[0][c];
			if(c > 1) {
				int tmpMax = 0;
				tmpMax = Math.max(dp[0][c-2], dp[1][c-2]) + vals[0][c];
				dp[0][c] = Math.max(dp[0][c], tmpMax);
			}
			
			dp[1][c] = dp[0][c-1] + vals[1][c];
			if(c > 1) {
				int tmpMax = 0;
				tmpMax = Math.max(dp[0][c-2], dp[1][c-2]) + vals[1][c];
				dp[1][c] = Math.max(dp[1][c], tmpMax);
			}
		}
		
		return dp;
	}

}