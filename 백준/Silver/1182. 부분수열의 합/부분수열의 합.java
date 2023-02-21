import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*[ 문제 유형 ] 부분 집합 subset()
 * 순서 의미 x, 중복 x, 개수 제한 x 
 */
public class Main {

	static int N, S, ans;
	static int[] arr;
	static boolean[] selected;
	
	private static void dfs(int cnt, int sum) {	
		if(cnt == N) {
			if(sum == S) ans++;	
			return;
		}
		
		dfs(cnt + 1, sum + arr[cnt]);
		dfs(cnt + 1, sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		dfs(0, 0);
		if(S == 0)
			System.out.println(ans - 1);	// 공집합 제외
		else
			System.out.println(ans);
			
	}

}