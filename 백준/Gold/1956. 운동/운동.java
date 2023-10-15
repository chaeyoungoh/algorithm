import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1];
        int INF = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] = INF;
            }
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[s][e] = c;
        }

        for(int m=1; m<=N; m++) {
            for(int s=1; s<=N; s++) {
                if(map[s][m] == INF)    continue;
                    for(int e=1; e<=N; e++) {
                        if(map[m][e] == INF)    continue;
                        map[s][e] = Math.min(map[s][e], map[s][m] + map[m][e]);
                    }
            }
        }

        int answer = INF;
        for(int i=1; i<=N; i++) {
            answer = Math.min(answer, map[i][i]);
        }
        if(answer == INF)
            answer = -1;
        System.out.print(answer);
    }
}