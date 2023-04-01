import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N+1][3];
		
		
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] D = new int[N+1][3];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				int val1 = cost[i][j] + D[i-1][(j+1) % 3];
				int val2 = cost[i][j] + D[i-1][(j+2) % 3];
				D[i][j] = Math.min(val1, val2);
			}
		}

		int ans = Math.min(D[N][0], D[N][1]);
		ans = Math.min(ans, D[N][2]);
		System.out.println(ans);	
	}

}