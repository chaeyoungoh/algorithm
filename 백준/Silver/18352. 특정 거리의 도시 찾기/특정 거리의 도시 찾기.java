import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> cities = new ArrayList<>();
        for(int i=0; i<=N; i++)
            cities.add(new ArrayList<>());
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            cities.get(s).add(e);
        }

        bfs(cities, N, K, X);

        if(sb.length() == 0)
            System.out.println(-1);
        else
            System.out.print(sb.toString());
    }

    private static void bfs(ArrayList<ArrayList<Integer>> cities, int n, int k, int x) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visitied = new boolean[n+1];
        que.offer(x);
        int cnt = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i=1; i<=size; i++) {
                int cur = que.poll();
                visitied[cur] = true;
                for(int next : cities.get(cur)) {
                    if(visitied[next])  continue;
                    visitied[next] = true;
                    que.offer(next);
                }
            }
            cnt++;
            if(cnt == k)    break;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!que.isEmpty())
            list.add(que.poll());
        Collections.sort(list);

        for(int i : list)
            sb.append(i).append('\n');

    }
}