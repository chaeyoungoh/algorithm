import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, max, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        max = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(map[i][j] == 0)  continue;
                if(visited[i][j])   continue;
                cnt = 1;
                visited[i][j] = true;
                dfs(i, j);
                max = Math.max(max, cnt);
            }
        }

        System.out.print(max);
    }

    public static void dfs(int r, int c) {
        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr<=0 || nr>N || nc<=0 || nc>M)    continue;
            if(map[nr][nc] == 0)    continue;
            if(visited[nr][nc]) continue;
            visited[nr][nc] = true;
            cnt++;
            dfs(nr, nc);
        }
    }
}