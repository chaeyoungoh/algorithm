import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, MAX;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
//        vis = new boolean[R][C];

        String s;
        for(int i=0; i<R; i++) {
            s = br.readLine();
            for(int j=0; j<C; j++) {
                if(s.charAt(j) == 'L')
                    map[i][j] = true;
            }
        }
//        System.out.println(Arrays.deepToString(map));

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]) {
//                    if(vis[i][j])   continue;
                    bfs(i, j, 0);
                }
            }
        }

        System.out.println(MAX);
    }

    static class Point {
        int r, c, w;
        public Point(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }

    public static void bfs(int r, int c, int w) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        boolean[][] vis = new boolean[R][C];
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(r, c, w));
        vis[r][c] = true;

        while(!que.isEmpty()) {
            Point tmp = que.poll();

            int tr = tmp.r;
            int tc = tmp.c;
            int cnt = tmp.w;;

            MAX = Math.max(MAX, cnt);
//            System.out.println(tr + " " +  tc+ " " + cnt);
//            vis[tr][tc] = true;

            for(int d=0; d<dr.length; d++) {
                int nr = tr + dr[d];
                int nc = tc + dc[d];
                if(nr < 0 || nc < 0 || nr >= R || nc >=C)   continue;
                if(!map[nr][nc])    continue;
                if(vis[nr][nc])     continue;
                vis[nr][nc] = true;
                que.offer(new Point(nr, nc, cnt+1));
            }


        }

    }
}