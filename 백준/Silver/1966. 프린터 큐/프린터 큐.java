import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Paper {
		int idx;
		int prior;
		public Paper(int idx, int prior) {
			this.idx = idx;
			this.prior = prior;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Integer[] arrPri = new Integer[N];
			Queue<Paper> que = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(st.nextToken());
				arrPri[i] = num;
				que.add(new Paper(i, num));
			}
			Arrays.sort(arrPri, Collections.reverseOrder());
			
			int cnt = 0;
			while(!que.isEmpty()) {
				Paper cur = que.poll();
				if(cur.prior != arrPri[cnt]) {
					que.add(cur);
				} else {
					cnt++;
					if(cur.idx == M) {
						sb.append(cnt).append('\n');
						break;
					}
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}