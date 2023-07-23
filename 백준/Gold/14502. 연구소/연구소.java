import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r  = r;
            this.c = c;
        }
    }

    static List<Point> zero, virus;
    static int N, M, max;
    static Point[] sel;
    static int[][] map;
    static boolean[] permVis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        zero = new ArrayList<>();       // 빈칸. 벽을 세울 수 있는 곳(=중복 없는 조합 3개 잡기 위한 리스트)
        virus = new ArrayList<>();      // 처음 바이러스가 있는 곳.
        max = Integer.MIN_VALUE;        // 안전영역 최대 카운트 담을 변수
        sel = new Point[3];             // 조합 담을 배열
        map = new int[N][M];            // 처음 받은 지도

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0)
                    zero.add(new Point(i, j));
                else if(map[i][j] == 2)
                    virus.add(new Point(i , j));
            }
        }

//        for(Point p : virus)
//            System.out.print(p.r + " , " + p.c + " || ");
//        System.out.println();
//        for(Point p : zero)
//            System.out.print(p.r + " , " + p.c + " || ");

        permVis = new boolean[zero.size()];     // 조합용 방문처리 배열

        perm(0, 0);

        System.out.print(max);
    }

//  조합 (중복x)
    private static void perm(int cnt, int start) {
        if(cnt == 3) {
            int tmp = countSafeZone();
            if(tmp > max) {
                max = tmp;
//                System.out.println(max + " ::: "
//                        + sel[0].r + "," + sel[0].c + " "
//                        + sel[1].r + "," + sel[1].c + " "
//                        + sel[2].r + "," + sel[2].c);
            }

            return;
        }

        for(int i=start; i< zero.size(); i++) {
            if(permVis[i])  continue;
            permVis[i] = true;
            sel[cnt] = zero.get(i);
            perm(cnt + 1, i + 1);
            permVis[i] = false;
        }
    }

//  1.벽 세우고 -> 2.바이러스 퍼트리고 -> 3. 안전영역 카운트
    private static int countSafeZone() {
        int[][] dup = copyMap();
//        1.
        for(Point p : sel) {
            dup[p.r][p.c] = 1;
        }
//        2. 4방탐색
        int[][] result = bfs(dup);

//        3. 카운트
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(result[i][j] == 0)  cnt++;
            }
        }

        return cnt;
    }

    private static int[][] bfs(int[][] dup) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        boolean[][] visited = new boolean[N][M];
        Queue<Point> que = new LinkedList<>();
        for(Point p : virus) {
            que.add(p);
        }

        while(!que.isEmpty()) {
            Point tmp = que.poll();
            int r = tmp.r;
            int c = tmp.c;
            visited[r][c] = true;
            for(int d=0; d<4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M)  continue;
                if(dup[nr][nc] != 0)    continue;
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                dup[nr][nc] = 2;
                que.offer(new Point(nr, nc));
            }
        }

        return dup;
    }

    //  지도 복사본 만들기
    private static int[][] copyMap() {
        int[][] dup = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dup[i][j] = map[i][j];
            }
        }
        return dup;
    }
 }