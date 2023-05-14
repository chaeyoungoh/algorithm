import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
//		+[0]	-[1]	*[2]	/[3]
//		operators : 쓸 수 있는 연산자 모음(index로 담음)
		int[] operators = new int[N-1];
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int m = Integer.parseInt(st.nextToken());
			for(int k=1; k<=m; k++) {
				operators[cnt++] = i; 	
			}
		}
	
//		permutation(중복 X)
		perm(N, nums, operators, new int[N-1], new boolean[N-1], 0);

//		output
		System.out.println(max);
		System.out.println(min);
	}

//	selected: 연산자 순서 순열
	private static void perm(int N, int[] nums, int[] operators, int[] selected, boolean[] visited, int cnt) {
		if(cnt == N-1) {
			calc(selected, nums, operators);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(visited[i]) continue;
			selected[cnt] = i;
			visited[i] = true;
			perm(N, nums, operators, selected, visited, cnt+1);
			visited[i] = false;			
		}
	}
	
	private static void calc(int[] selected, int[] nums, int[] operators) {
		int val = nums[0];
		int idx = 1;
		while(idx < nums.length) {
//		    tmp = operator[] index	
			for(int tmp : selected) {
				int operIdx = operators[tmp];

				switch(operIdx) {
					case 0:
						val += nums[idx];
						break;
					case 1:
						val -= nums[idx];
						break;
					case 2:
						val *= nums[idx];
						break;
					case 3:
						if(val < 0)
							val = ((val * -1) / nums[idx]) * -1;
						else
							val /= nums[idx];
						break;
					default:	
						break;
				}
				idx++;
			}
		}

		max = Math.max(max, val);
		min = Math.min(min, val);
		
	}
}