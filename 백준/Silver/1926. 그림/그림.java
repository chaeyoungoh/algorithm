import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean[][] vis;
    static List<Integer> cnts;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
//        1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        List<Point> list = new ArrayList<>();
        vis = new boolean[R][C];
        cnts = new ArrayList<>();

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    list.add(new Point(i, j));
            }
        }

//        2. bfs
        for(Point p : list) {
            if(vis[p.r][p.c])   continue;
            bfs(p, map, R, C);
        }

        Collections.sort(cnts);

        sb.append(cnts.size()).append('\n');
        if(cnts.size() == 0)
            sb.append(0);
        else
            sb.append(cnts.get(cnts.size()-1));
        System.out.println(sb.toString());
    }

    public static void bfs(Point p, int[][] map, int R, int C) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        Queue<Point> que = new LinkedList<>();
        que.offer(p);
        vis[p.r][p.c] = true;
        int cnt = 1;

        while(!que.isEmpty()) {
            Point tmp = que.poll();
            for(int d=0; d<4; d++) {
                int nr = tmp.r + dr[d];
                int nc = tmp.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C)  continue;
                if(map[nr][nc] == 0)    continue;
                if(vis[nr][nc])         continue;
                vis[nr][nc] = true;
                que.offer(new Point(nr, nc));
                cnt++;
            }
        }
        cnts.add(cnt);
    }
}