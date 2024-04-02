import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long[] solution(long[] dp) {
        for(int i=6; i<=100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }
        return dp;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        dp = solution(dp);
        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb.toString());
    }
}