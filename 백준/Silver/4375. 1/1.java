import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        int N, cnt;
        long num;
        while((input = br.readLine()) != null) {
            N = Integer.parseInt(input);
            num = 1;
            cnt = 1;
            while(num % N != 0) {
                num = num * 10 + 1;
                num %= N;
                cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb.toString());
    }
}