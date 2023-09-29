import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int t2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int t = (t1 * b2) + (t2 * b1);
        int b = b1 * b2;

        mod(t, b);

        System.out.print(sb.toString());
    }

    private static void mod(int t, int b) {
        int len;
        if(t > b)   len = b;
        else    len = t;

        for(int i=2; i<=len; i++) {
            while(t % i == 0 && b % i == 0) {
                t /= i;
                b /= i;
            }
        }
        sb.append(t).append(' ').append(b);
    }
}