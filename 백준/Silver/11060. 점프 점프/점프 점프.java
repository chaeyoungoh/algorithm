import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            map[i] = Integer.parseInt(st.nextToken());

        boolean flag = bfs(map, N);
        if(flag)
            System.out.print(cnt - 1);
        else
            System.out.print(-1);
    }

    public static boolean bfs(int[] map, int n) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        que.offer(1);
        visited[1] = true;

        cnt = 0;
        while(!que.isEmpty()) {
            int len = que.size();
            cnt++;
            for(int size=0; size<len; size++) {
                int cur = que.poll();
                if(cur == n)     return true;
                int jump = map[cur];
                if(jump == 0)   continue;
                for(int i=1; i<=jump; i++) {
                    int nx = cur + i;
                    if(nx > n)  continue;
                    if(visited[nx]) continue;
                    que.offer(nx);
                    visited[nx] = true;
                }
            }
        }
        return false;
    }

}