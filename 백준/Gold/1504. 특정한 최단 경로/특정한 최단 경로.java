import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int e; int w;
        public Point(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w - o.w;        // 오름차순
        }
    }

    static int answer = -1;
    static ArrayList<Point>[] list;
    static int N, E;
    static int v1, v2;
    static int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<Point>();
        }
        for(int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Point(e, w));
            list[e].add(new Point(s, w));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        /* 다익스트라 : 3번 * 2번
        * 1. 1 -> v1    || 1 -> v2
        * 2. v1 -> v2   || v2 -> v2
        * 3. v2 -> N    || v1 -> N
        */

        /* case 1 : 1 - v1 - v2 - N */
        int sum1 = dijk(1, v1) + dijk(v1, v2) + dijk(v2, N);
        int sum2 = dijk(1, v2) + dijk(v2, v1) + dijk(v1, N);

        answer = Math.min(sum1, sum2);
        if(answer > INF || E == 0)    answer = -1;
        System.out.println(answer);
    }

    public static int dijk(int start, int end) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        int[] dis = new int[N+1];
        Arrays.fill(dis, INF);

//        boolean[] vis = new boolean[N+1];

        dis[start] = 0;
        pq.offer(new Point(start, 0));
        while(!pq.isEmpty()) {
            Point tmp = pq.poll();
            int e = tmp.e;
//            if(vis[e])  continue;
//            vis[e] = true;
            for(Point point : list[e]) {
                int ne = point.e;
                int nw = point.w;;
//                if(vis[ne]) continue;
                if(dis[ne] > dis[e] + nw) {
                    dis[ne] = dis[e] + nw;
                    pq.offer(new Point(ne, dis[ne]));
                }
            }
        }

        return dis[end];
    }
}