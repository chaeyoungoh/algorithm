import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];		
		int INF = 1000000;
		Arrays.fill(arr, INF);
		
		arr[0] = 0;
		
		for(int i=2; i<=N; i++) {
			if(i < 5)
				arr[i] = arr[i-2] + 1;
			else {
				arr[i] = Math.min(arr[i-5] + 1, arr[i-2] + 1);
			}
		}
		
		int ans = -1;
		if(arr[N] < INF) 
			ans = arr[N];
		System.out.println(ans);
	}

}