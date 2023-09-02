import java.awt.*;
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

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Node> list[] = new ArrayList[N+1];
        for(int i=0; i<N+1; i++)
            list[i] = new ArrayList<>();
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        boolean[] vis = new boolean[N+1];
        for(int i=1; i<N+1; i++) {
            vis[i] = true;
            dfs(i, list, vis, 0, N);
            vis[i] = false;
        }

        System.out.println(answer);
    }

    private static void dfs(int idx, List<Node>[] list, boolean[] vis, int sum, int N) {
        for(Node node : list[idx]) {
            if(vis[node.e]) continue;
            vis[node.e] = true;
            dfs(node.e, list, vis, sum + node.w, N);
            vis[node.e] = false;
        }

        answer = Math.max(sum, answer);
    }

}