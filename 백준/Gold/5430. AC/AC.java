import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	static StringBuilder sb = new StringBuilder();

	private static void ac(Deque<String> que, String s) {
		boolean front = true;
		
		for(char c : s.toCharArray()) {
			if(c == 'R') {
//				R : 방향 반대
				front = !front;
				continue;
			} else {
//				D : 삭제
				if(que.isEmpty()) {
					sb.append("error").append('\n');
					return;
				}
				if(front) {
					que.pollFirst();
				} else {
					que.pollLast();
				}
			}
		}
//		출력
		printQue(que, front);
		
	}

	private static void printQue(Deque<String> que, boolean front) {
		sb.append('[');
		if(que.size() > 0) {
			
			if(front) {
				sb.append(que.pollFirst());
			} else {
				sb.append(que.pollLast());				
			}
			
			while(que.size() > 0) {				
				if(front) {
					sb.append(',').append(que.pollFirst());
				} else {
					sb.append(',').append(que.pollLast());				
				}
			}
		}
		sb.append(']').append('\n');		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String S = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String ARR = br.readLine();
			
			ARR = ARR.replace("[", "").replace("]", "");
			String[] tmp = ARR.split(",");
			
			Deque<String> que = new LinkedList<>();
			if(N > 0) {
				for(String s : tmp) 
					que.offer(s);
			}
			
			ac(que,S);
		}
		
		System.out.println(sb.toString());
	}

}