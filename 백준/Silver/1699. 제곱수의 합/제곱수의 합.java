import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N+1];
        for(int i=1; i<=N; i++)
            DP[i] = i;
        for(int i=1; i<=Math.sqrt(N); i++)
            DP[i*i] = 1;

        for(int i=1; i<=N; i++) {
            DP[i] = Math.min(DP[i], DP[i-1] + 1);
            for(int j=1; j<i; j++)
                DP[i] = Math.min(DP[i], DP[i-j] + DP[j]);
        }

        System.out.println(DP[N]);
    }

}