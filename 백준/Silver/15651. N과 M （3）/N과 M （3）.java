import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [문제 유형] 중복 가능 순열
 * 순서 의미 o, 중복 o
 * */

public class Main {

	static int N, M;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		perm(0);
		System.out.println(sb.toString());
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++)
				sb.append(selected[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i < N + 1; i++) {
			selected[cnt] = i;
			perm(cnt + 1);
		}

	}

}