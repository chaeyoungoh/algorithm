import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums, selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        selected = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);

        combi(0, 0);
        System.out.print(sb.toString());
    }

    private static void combi(int cnt, int start) {
        if(cnt == M) {
            for(int i : selected)
                sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        for(int i=start; i<N; i++) {
            if(visited[i])  continue;
            visited[i] = true;
            selected[cnt] = nums[i];
            combi(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}