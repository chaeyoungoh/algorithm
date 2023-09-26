import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int len = S.length();
        HashSet<String> set = new HashSet<>();

        for(int i=1; i<=len; i++) {
            for(int s=0; s<=len-i; s++) {
                set.add(S.substring(s, s+i));
            }
        }

        int answer = set.size();
        System.out.print(answer);

    }
}