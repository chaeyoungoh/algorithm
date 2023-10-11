import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Node>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }

        bfs(list, N);

        System.out.print(result);
    }
    public static void bfs(ArrayList<Node>[] list, int n) {
        PriorityQueue<Node> pq = new PriorityQueue();
        boolean[] visited = new boolean[n+1];

        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int to = cur.to;
            if(visited[to]) continue;
            int cost = cur.cost;
            visited[to] = true;
            result += cost;

            for(Node nx : list[to]) {
                if(visited[nx.to])  continue;
                pq.offer(nx);
            }
        }
    }
}