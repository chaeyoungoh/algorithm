import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder result = new StringBuilder();
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			cnt = 0;
			backTracking(0, N);
			result.append(cnt).append('\n');
		}
		
		System.out.println(result.toString());
	}

	private static void backTracking(int sum, int n) {
		if(sum >= n) {
			if(sum == n)	cnt++;
			return;
		}
		
		backTracking(sum + 1, n);
		backTracking(sum + 2, n);
		backTracking(sum + 3, n);
	}

}