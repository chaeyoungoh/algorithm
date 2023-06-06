import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			s = br.readLine();
			doQueue(s, dq);
		}
		
		System.out.println(sb.toString());
	}

	private static void doQueue(String s, ArrayDeque<Integer> dq) {
		StringTokenizer st = new StringTokenizer(s);
		String tmp = st.nextToken();
		
		switch(tmp) {
		case "push" :
			dq.offer(Integer.parseInt(st.nextToken()));
			break;
		case "pop" :
			if(dq.size() > 0)
				sb.append(dq.pollFirst()).append('\n');
			else
				sb.append(-1).append('\n');
			break;
		case "size" :
			sb.append(dq.size()).append('\n');
			break;
		case "empty" :
			if(dq.isEmpty())
				sb.append(1).append('\n');
			else
				sb.append(0).append('\n');
			break;
		case "front" :
			if(dq.size() > 0)
				sb.append(dq.peekFirst()).append('\n');
			else
				sb.append(-1).append('\n');
			break;
		case "back" :
			if(dq.size() > 0)
				sb.append(dq.peekLast()).append('\n');
			else
				sb.append(-1).append('\n');
			break;
			
		}
	}

	
}