import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        StringTokenizer st;
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }

        bfs(list, N);

        System.out.print(result - 1);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> list, int n) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        que.offer(1);
        int cnt = 0;
        result = 0;
        while(!que.isEmpty()) {
            int len = que.size();
            for(int i=1; i<=len; i++) {
                int cur = que.poll();
                if(visited[cur])    continue;
                visited[cur] = true;
                result++;
                for(int nx : list.get(cur)) {
                    if(visited[nx]) continue;
                    que.offer(nx);
                }
            }
            cnt++;
            if(cnt > 2) break;
        }
    }
}