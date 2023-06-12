import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] nums, selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		selected = new int[N];
		for(int i=0; i<N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		
		for(int i=0; i<N; i++)	{
			selected[0] = nums[i];
			perm(1, i);
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static void perm(int cnt, int s) {
		if(cnt == M) {			
			for(int i=0; i<M; i++)
				sb.append(selected[i]).append(' ');		
			sb.append('\n');			
			return;
		}
		
		for(int i=s; i<N; i++) {
			selected[cnt] = nums[i];
			perm(cnt+1, i);
		}
	}

}