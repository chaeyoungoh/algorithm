import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static boolean isThere(int cur, int[] arr) {
		int lt=0, rt=arr.length-1;
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			
			if(cur > arr[mid]) {
				lt = mid + 1;
			} else if(cur < arr[mid]) {
				rt = mid - 1;
			} else {
				return true;
			}
		}
		
		return false;	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i=0; i<M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(isThere(cur, arr))
				sb.append(1).append(' ');
			else
				sb.append(0).append(' ');
		}
		
		System.out.println(sb.toString());	
	}

}