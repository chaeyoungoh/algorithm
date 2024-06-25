import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = 6;
        String s;
        StringTokenizer st;
        while((s=br.readLine()).charAt(0) != '0') {
            st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];
            int[] selected = new int[goal];
            boolean[] visited = new boolean[N];
            for(int i=0; i<N; i++)
                nums[i] = Integer.parseInt(st.nextToken());
            combination(selected, visited, nums, 0, 0, goal, N);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    private static void combination(int[] sel, boolean[] vis, int[] nums, int cnt, int start, int goal, int n) {
        if(cnt == goal) {
            for(int num : sel)
                sb.append(num).append(' ');
            sb.append('\n');
            return;
        }
        for(int i=start; i<n; i++) {
            if(vis[i])  continue;
            vis[i] = true;
            sel[cnt] = nums[i];
            combination(sel, vis, nums, cnt+1, i+1, goal, n);
            vis[i] = false;
        }
    }
}