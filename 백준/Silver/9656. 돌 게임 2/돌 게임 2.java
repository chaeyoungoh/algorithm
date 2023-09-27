import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static class Stone {
        int val, cnt;
        public Stone(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = bfs(N);

        String answer = "";
        if(cnt % 2 == 0)
            answer = "CY";
        else
            answer = "SK";

        System.out.print(answer);
    }

    public static int bfs(int n) {
        boolean[] visitied = new boolean[n+1];
        Queue<Stone> que = new LinkedList<>();
        que.offer(new Stone(n, 0));
        visitied[n] = true;

        while(!que.isEmpty()) {
            Stone cur = que.poll();
            int val = cur.val;
            int cnt = cur.cnt;
            if(val == 1)    return cnt;

            if(val > 3) {
                if(visitied[val-3]) continue;
                visitied[val-3] = true;
                que.offer(new Stone(val-3, cnt+1));
            }
            if(visitied[val-1]) continue;
            visitied[val-1] = true;
            que.offer(new Stone(val-1, cnt+1));
        }
        return -1;

    }
}