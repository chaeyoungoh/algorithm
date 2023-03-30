import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	private static void check(String s, Stack<Integer> stack, StringBuilder sb) {

		if(s.equals("pop")) {
			if(stack.size() == 0) 
				sb.append(-1).append('\n');
			else
				sb.append(stack.pop()).append('\n');
		} else if(s.equals("size")) {
			sb.append(stack.size()).append('\n');
		} else if(s.equals("empty")) {
			if(stack.isEmpty())
				sb.append(1).append('\n');
			else
				sb.append(0).append('\n');
				
		} else if(s.equals("top")) {
			if(stack.size() == 0) 
				sb.append(-1).append('\n');
			else
				sb.append(stack.peek()).append('\n');
		} else {
			StringTokenizer st = new StringTokenizer(s);
			st.nextToken();
			stack.push(Integer.parseInt(st.nextToken()));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int c=0; c<N; c++) {
			String s = br.readLine();
			
			check(s, stack, sb);
		}
		
		System.out.println(sb.toString());
	}

}