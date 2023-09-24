import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        /* 공통 원소 개수만 찾기 */
        int cnt = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : A)
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        for(int i : B) {
            if(hm.containsKey(i))   cnt++;
        }

        int answer = (A.length - cnt) + (B.length - cnt);
        System.out.println(answer);
    }
}