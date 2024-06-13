import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        System.out.println(solution(str, bomb));
    }
    public static String solution(String str, String bomb) {
        int bombSize = bomb.length();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            stack.push(str.charAt(i));
            
            if(stack.size() >= bombSize) {
                boolean flag = true;
                for(int j=0; j<bombSize; j++) {
                    if(stack.get(stack.size() - bombSize + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int k=0; k<bombSize; k++)
                        stack.pop();
                }
            }
        }

        if(stack.isEmpty())
            return "FRULA";
        else {
            StringBuilder sb = new StringBuilder();
            for(char c : stack)
                sb.append(c);
            return sb.toString();
        }
    }
}