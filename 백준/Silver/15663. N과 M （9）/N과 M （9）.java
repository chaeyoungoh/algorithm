import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 순열. 중복 안 됨.
public class Main {

    static int N, M;
    static int[] nums;
    static int[] selected;
    static boolean[] visited;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        selected = new int[M];
        visited = new boolean[N];
        nums = new int[N];

        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        perm(0);

        for(String s : set)
            System.out.println(s);
    }
    private static void perm(int cnt) {
        if(cnt == M) {
            StringBuilder sb = new StringBuilder();
            for(int i : selected)
                sb.append(i).append(' ');
            set.add(sb.toString());
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(visited[i])  continue;
            visited[i] = true;
            selected[cnt] = nums[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }

}