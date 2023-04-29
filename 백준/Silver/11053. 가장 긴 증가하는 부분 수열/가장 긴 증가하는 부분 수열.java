import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			nums[i] = Integer.parseInt(st.nextToken());
//		2. DP
		int[] DP = new int[N];
		Arrays.fill(DP, 1);
		int max = 1;
		for(int i=1; i<N;i++) {
			for(int j=0; j<i; j++) { 
				if(nums[i] > nums[j]) {
					DP[i] = Math.max(DP[i], DP[j] + 1);
					if(DP[i] > max)
						max = DP[i];
				}
			}
		}

//		3. output : max
		System.out.println(max);
	}

}