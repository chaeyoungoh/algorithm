import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int getSum(int goal, int[] arr) {
		int min = Integer.MAX_VALUE;
		int cnt = 0, sum = 0;
		
		int lt = 0;

		for(int rt = 0; rt < arr.length; rt++) {
			sum += arr[rt];
			cnt++;
			while(sum >= goal) {
				min = Math.min(min, cnt);
				
				sum -= arr[lt++];
				cnt--;
			}
		}
		
		if(min == Integer.MAX_VALUE) min = 0;
		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int ans = getSum(S, arr);
		System.out.println(ans);
	}

}