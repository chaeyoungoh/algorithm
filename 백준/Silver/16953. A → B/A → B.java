import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int FIN = Integer.MAX_VALUE;
	static int minCnt = FIN;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		dfs(A, B, 1);
		if(minCnt == FIN) 
			minCnt = -1;
		System.out.println(minCnt);
	}

	private static void dfs(long s, long e, int cnt) {
		if(s == e) {
			minCnt = Math.min(minCnt, cnt);
			return;
		}
		if(s > e)	return;
		if(cnt > minCnt)	return;
		
		dfs(s * 2, e, cnt+1);
		dfs(s * 10 + 1, e, cnt+1);					
		return;
	}

}