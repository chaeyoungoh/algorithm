import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Point implements Comparable<Point> {
        int r;      int c;
        int cnt;    int punch;
        public Point(int r, int c, int cnt, int punch) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.punch = punch;
        }
        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt == 0 ? this.punch - o.punch : this.cnt - o.cnt;
        }
    }
    static int N, M;
    static int[][] map;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=M; j++) {
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][][] visited = new boolean[N+1][M+1][2];

        pq.offer(new Point(1, 1, 1, 0));
        visited[1][1][0] = true;

        while(!pq.isEmpty()) {
            Point tmp = pq.poll();
            int r = tmp.r;
            int c = tmp.c;
            int cnt = tmp.cnt;
            int punch = tmp.punch;

//            System.out.println(cnt + " ::: punch " + punch + " >>> " + r + " " + c);

            if(r == N && c == M) {
                answer = cnt;
                return;
             }

            for(int d=0; d<dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(outOfRange(nr, nc))  continue;
                if(visited[nr][nc][punch])     continue;

                if(map[nr][nc] == 0) {  // 벽 아닌 경우
                    pq.offer(new Point(nr, nc, cnt+1, punch));
                    visited[nr][nc][punch] = true;
                }
                else {      //  벽인 경우
                   if(punch == 0) {
                       pq.offer(new Point(nr, nc, cnt+1, punch+1));
                       visited[nr][nc][1] = true;
                   }

                }
            }
        }
    }

    private static boolean outOfRange(int nr, int nc) {
        if(nr<=0 || nc<=0 || nr>N || nc>M)
            return true;
        return false;
    }

}