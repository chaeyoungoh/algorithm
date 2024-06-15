import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(check(br.readLine()))     cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean check(String voca) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<voca.length(); i++) {
            char tmp = voca.charAt(i);
           if(stack.size() == 0) {
               stack.push(tmp);
               continue;
           }
           if(stack.peek() == tmp)
               stack.pop();
           else
               stack.push(tmp);
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}