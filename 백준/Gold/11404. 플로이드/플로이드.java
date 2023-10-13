import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int INF = 99999999;
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] = INF;
                if(i==j)    map[i][j] = 0;
            }
        }

        StringTokenizer st;
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[from][to] = Math.min(map[from][to], cost);
        }

        fw(N);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] == INF) {
                    map[i][j] = 0;
                }
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    public static void fw(int n) {
        for(int i=1; i<=n; i++) {
            for(int s=1; s<=n; s++) {
                for(int e=1; e<=n; e++) {
                    if(map[s][e] > map[s][i] + map[i][e]) {
                        map[s][e] = map[s][i] + map[i][e];
                    }
                }
            }
        }
    }
}