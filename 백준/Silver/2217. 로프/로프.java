import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lopes = new int[N];
        for(int i=0; i<N; i++)
            lopes[i] = Integer.parseInt(br.readLine());
        Arrays.sort(lopes);
        long answer = -1;

        for(int i=0; i<N; i++) {
            long sum = 0;
            int lopeNum = N - i;
            sum = lopes[i] * lopeNum;
//            System.out.println(" ::: " + sum);
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}