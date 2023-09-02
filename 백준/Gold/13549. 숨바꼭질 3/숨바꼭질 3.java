import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int spot;
        int cnt;
        public Point(int spot, int cnt) {
            this.spot = spot;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        find(S, E);

        System.out.println(ans);
    }

    private static void find(int start, int end) {
        PriorityQueue<Point> que = new PriorityQueue<>();
        boolean[] vis = new boolean[100001];
        que.offer(new Point(start, 0));

        while(!que.isEmpty()) {
            Point tmp = que.poll();
            int spot = tmp.spot;
            int cnt = tmp.cnt;

            if(spot == end) {
                ans = Math.min(cnt, ans);
                return;
            }

            if(vis[spot])   continue;
            vis[spot] = true;

            if(spot * 2 <= 100000)
                que.offer(new Point(spot * 2, cnt));
            if(spot + 1 <= 100000)
                que.offer(new Point(spot + 1, cnt + 1));
            if(spot - 1 >= 0)
                que.offer(new Point(spot - 1, cnt + 1));
        }

    }
}