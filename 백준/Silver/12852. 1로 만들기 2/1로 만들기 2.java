import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[] before = new int[N+1];

        dp[1] = 0;
        before[1] = -1;

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;

            if(i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }

            if(i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N]).append('\n');

        int num = N;
        for(int i=0; i<=dp[N]; i++) {
            sb.append(num).append(' ');
            num = before[num];
        }

        System.out.print(sb.toString());

    }
}