import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N+1][N+1];
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = true;
        }

        /* F.W */
        for(int m=1; m<=N; m++) {
            for(int s=1; s<=N; s++) {
                for(int e=1; e<=N; e++) {
                    if(map[s][m] && map[m][e])
                        map[s][e] = true;
                }
            }
        }

        int[] cnt = new int[N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] || map[j][i])  cnt[i]++;
            }
        }

//        System.out.println(Arrays.deepToString(map));

        int result = 0;
        for(int i=1; i<=N; i++) {
            if(cnt[i] == N-1) result++;
        }
        System.out.print(result);
    }
}