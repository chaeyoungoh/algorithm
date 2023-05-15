import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int[] costs, DP;
	
	public static void main(String[] args) throws IOException {
//		input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		costs = new int[N+1];
		for(int i=1; i<=N; i++) 
			costs[i] = Integer.parseInt(st.nextToken());
		
//		DP
		DP = new int[N+1];
		DP[1] = costs[1];
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=i; j++) 
				DP[i] = Math.max(DP[i-j] + costs[j], DP[i]);
		}
		
//		output
		System.out.println(DP[N]);
		
	}

}