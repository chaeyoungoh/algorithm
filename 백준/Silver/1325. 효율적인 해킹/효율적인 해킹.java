import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int max;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int[] cnts;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
        }

        cnts = new int[N+1];
        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
//            if(visited[i])  continue;
            bfs(i);
        }
        for(int i=1; i<=N; i++) {
            if(cnts[i] > max)
                max = cnts[i];
        }
        for(int i=1; i<=N; i++) {
            if(cnts[i] == max)
                sb.append(i).append(' ');
        }

        System.out.print(sb.toString());
    }

    public static void bfs(int s) {
        Queue<Integer> que = new LinkedList<>();
        visited[s] = true;
        que.offer(s);

        while(!que.isEmpty()) {
            int cur = que.poll();
            for(int nx : list.get(cur)) {
                if(visited[nx]) continue;
                visited[nx] = true;
                que.offer(nx);
                cnts[nx]++;
            }
        }
    }
}