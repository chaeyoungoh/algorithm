import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int r, c, cnt;
        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        result = new int[N][M];

        Point start = new Point(0, 0, 0);
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    result[i][j] = 0;
                    start = new Point(i, j, 0);
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 1)
                    result[i][j] = -1;
            }
        }

        bfs(map, start, N, M);

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
              sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
    public static void bfs(int[][] map, Point start, int n, int m) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        Queue<Point> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        visited[start.r][start.c] = true;
        que.offer(start);
        while(!que.isEmpty()) {
            Point cur = que.poll();
            int r = cur.r;
            int c = cur.c;
            int cnt = cur.cnt;
            for(int d=0; d<dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr<0 || nc<0 || nr>=n || nc>=m)  continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    continue;
                }
                visited[nr][nc] = true;
                result[nr][nc] = cnt + 1;
                que.offer(new Point(nr, nc, cnt+1));
            }
        }
    }
}