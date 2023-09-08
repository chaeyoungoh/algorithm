import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        long answer = recursive(A, B, C);

        System.out.println(answer);
    }

    private static long recursive(long a, long b, long c) {
        if(b == 1)  return a % c;
        long half = recursive(a, b / 2, c);
        return b % 2 == 0 ? (half * half % c) : (half * half % c) * a % c;
    }
}