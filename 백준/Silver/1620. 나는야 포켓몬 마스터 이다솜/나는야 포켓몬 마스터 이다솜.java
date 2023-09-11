import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N+1];
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            arr[i] = s;
            hm.put(s, i);
        }

        for(int i=1; i<=M; i++) {
            String s = br.readLine();
            if(Character.isDigit(s.charAt(0))) {
                sb.append(arr[Integer.parseInt(s)]).append('\n');
            }
            else {
                int idx = hm.get(s);
                sb.append(idx).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}