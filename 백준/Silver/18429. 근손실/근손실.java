import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, ans;
	static int[] workout;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		selected = new boolean[N];
		workout = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			workout[i] = Integer.parseInt(st.nextToken());
		
		calc(0, 0, 0);
		System.out.println(ans);
	}

	private static void calc(int cnt, int plus, int minus) {

		if(plus < minus) return;
		
		if(cnt == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < workout.length; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			calc(cnt + 1, plus + workout[i], minus + K);
			selected[i] = false;
		}
		
	}

}