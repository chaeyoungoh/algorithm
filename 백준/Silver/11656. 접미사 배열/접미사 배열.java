import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int len = S.length();
        String[] arr = new String[len];

        for(int i=0; i<len; i++) {
            arr[i] = S.substring(i);
        }

        Arrays.sort(arr);
        for(String s : arr)
            sb.append(s).append('\n');

        System.out.print(sb.toString());
    }
}