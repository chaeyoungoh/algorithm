import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] goal = new int[N+1];
		for(int i=1; i<=N; i++) 
			goal[i] = Integer.parseInt(br.readLine());
		
//		2. stack
		String answer = check(goal, N);
		
//		3. output
		System.out.println(answer);
		
	}

	private static String check(int[] goal, int N) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int idx = 1;
		for(int i=1; i<=N; i++) {
			stack.push(i);
			sb.append('+').append('\n');
			while(true) {
				if(stack.isEmpty()) 
					break;
				if(stack.peek() == goal[idx]) {
					stack.pop();
					sb.append('-').append('\n');
					idx++;
				}
				else
					break;
			}
		}
		
		if(stack.isEmpty())
			return sb.toString();
		else 
			return "NO";
	}

}