import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            hm.put(tmp, hm.getOrDefault(tmp, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
            b[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++)
            sb.append(hm.getOrDefault(b[i], 0)).append(' ');

        System.out.println(sb.toString());
    }
}