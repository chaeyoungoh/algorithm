import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] tri = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] DP = new int[N][N];
		DP[0][0] = tri[0][0];
		for(int i=1; i<N; i++) {
			for(int j=0; j<=i; j++) {
				
				DP[i][j] = Math.max(DP[i][j], DP[i-1][j] + tri[i][j]);
				
				if(j>0)
					DP[i][j] = Math.max(DP[i][j], DP[i-1][j-1] + tri[i][j]);
			}
		}
		
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<N; i++)
			ans = Math.max(ans, DP[N-1][i]);
		
		System.out.println(ans);
		
//		System.out.println(Arrays.deepToString(DP));
	}

}