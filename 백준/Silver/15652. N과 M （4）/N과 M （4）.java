import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [문제 유형] 중복 조합
 * 중복 가능, M개 선택, 순서 의미 없음.
 */

public class Main {

	static int N, M, start;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		start = 1;
		perm(1, 0);
		System.out.println(sb.toString());
	
	}

	private static void perm(int start, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i < N+1; i++) {
			selected[cnt] = i;
			perm(i, cnt + 1);
		}
		
	}

}