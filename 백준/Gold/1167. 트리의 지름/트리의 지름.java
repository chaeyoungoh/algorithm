import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int e;
        int w;
        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    static int max, edge;
    static ArrayList<Node>[] list;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                else  {
                    int w = Integer.parseInt(st.nextToken());
                    list[s].add(new Node(e, w));
                }
            }
        }

        vis = new boolean[N+1];
        dfs(0, 1);

        vis = new boolean[N+1];
        dfs(0, edge);

        System.out.println(max);
    }

    public static void dfs(int sum, int i) {
        if(sum > max) {
            max = sum;
            edge = i;
        }
        vis[i] = true;
        for(Node node : list[i]) {
            if(vis[node.e]) continue;
            dfs(sum + node.w, node.e);
        }
    }

}