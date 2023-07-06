import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        selected = new int[N+1];

        perm(1);

        System.out.println(sb.toString());
    }

    private static void perm(int cnt) {
        if(cnt == N+1) {
            for(int i=1; i<=N; i++)
                sb.append(selected[i]).append(' ');
            sb.append('\n');
        }
        for(int i=1; i<=N; i++) {
            if(visited[i])  continue;
            visited[i] = true;
            selected[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}