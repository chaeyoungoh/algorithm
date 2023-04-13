import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		boolean flag = false;
		for(char c : S.toCharArray()) {
			if(c == '<') {
				if(!stack.isEmpty()) {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				} 
				
				flag = true;
				sb.append(c);
			} else if(flag) {
				sb.append(c);
				if(c == '>') 
					flag = false;
			} else {
				if(c == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(c);
				} else 
					stack.push(c);
			}
		}
		
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		}
		
		System.out.println(sb.toString());
	}

}