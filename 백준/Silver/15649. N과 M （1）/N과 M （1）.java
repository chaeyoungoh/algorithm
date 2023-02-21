import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//	[ 문제 유형 ] 순열(순서의미 o, 중복x)
//	sol1. 백트래킹
//	sol2. permutation
	static int N, M;
	static int[] ans;
	static boolean[] selected;
	static StringBuilder sb ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new boolean[N+1];
		ans = new int[M];
		perm(0);
		System.out.println(sb.toString());
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for(int i : ans) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(selected[i]) continue;
			ans[cnt] = i;
			selected[i] = true;
			perm(cnt + 1);
			selected[i] = false;
		}
	}
}