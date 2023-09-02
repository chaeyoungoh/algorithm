import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int cnt, val;
        public Point(int cnt, int val) {
            this.cnt = cnt;
            this.val = val;
        }
    }

    static int FIN = Integer.MAX_VALUE;
    static int answer = FIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        bfs(E, S, G, U, D);
        if(answer != FIN)
            System.out.println(answer);
        else
            System.out.println("use the stairs");

    }
    private static void bfs(int end, int start, int goal, int up, int down) {
        Queue<Point> que = new LinkedList<>();
        boolean[] visited = new boolean[end + 1];
        que.offer(new Point(0, start));
        while(!que.isEmpty()) {
            Point tmp = que.poll();
            int val = tmp.val;
            int cnt = tmp.cnt;

            if(visited[val])    continue;
            visited[val] = true;
            if(val == goal) {
                answer = cnt;
                return;
            }

            if(val + up <= end && !visited[val + up])
                que.offer(new Point(cnt + 1, val + up));
            if(val - down > 0 && !visited[val - down])
                que.offer(new Point(cnt + 1, val - down));
        }

    }
}