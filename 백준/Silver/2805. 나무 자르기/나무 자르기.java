import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long answer;
    static int[] H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        H = new int[N];
        for(int i=0; i<N; i++)
            H[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(H);

        bs(0, H[N-1]);
        System.out.println(answer);
    }

    private static void bs(int s, int e) {
        while(s <= e) {
            int mid = (s + e) / 2;
            long tmpSum = cut(mid);
            if(tmpSum >= M) {
                answer = mid;
                s = mid + 1;
            } else if(tmpSum < M) {
                e = mid - 1;
            }
        }
    }

    private static long cut(long mid) {
        long sum = 0;
        for(int h : H)
            if(h > mid)
                sum += (h - mid);
        return sum;
    }
}