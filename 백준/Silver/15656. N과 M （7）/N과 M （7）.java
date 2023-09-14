import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
중복 가능 순열
 */
public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            set.add(Integer.parseInt(st.nextToken()));

        int[] selected = new int[M];
        perm(0, set, selected, N, M);

        System.out.println(sb.toString());
    }
    public static void perm(int cnt, TreeSet<Integer> set, int[] selected, int n, int m) {
        if(cnt == m){
            for(int s : selected)
                sb.append(s).append(' ');
            sb.append('\n');
            return;
        }
        for(int s : set) {
            selected[cnt] = s;
            perm(cnt+1, set, selected, n, m);
        }
    }
}