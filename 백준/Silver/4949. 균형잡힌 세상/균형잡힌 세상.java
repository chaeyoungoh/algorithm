import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		int idx = 0;
		boolean flag = true;
		
		while(s.charAt(0) != '.') {
			char tmp = s.charAt(0);
			while(tmp != '.') {
//				System.out.println(tmp);
				
				if(tmp == '(' || tmp == '[') {
					stack.push(tmp);
				}
				else if(tmp == ')' || tmp == ']') {
					if(stack.isEmpty()) {
						flag = false;
						break;	
					}
					
					if(stack.peek() == '(') {
						if(tmp == ')')
							stack.pop();
						else {
							flag = false;
							break;	
						}
					}
					else {
						if(tmp == ']')
							stack.pop();
						else {
							flag = false;
							break;	
						}
					}
					
				}
				tmp = s.charAt(++idx);
			}
			if(!stack.isEmpty())
				flag = false;
			if(flag) 
				sb.append("yes").append('\n');
			else
				sb.append("no").append('\n');
			
			s = br.readLine();
			idx = 0;
			flag = true;
			stack.clear();
		}
		
		System.out.println(sb.toString());
	}

}