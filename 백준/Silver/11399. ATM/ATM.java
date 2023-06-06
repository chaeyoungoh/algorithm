import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] times = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			times[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(times);
		int[] sumOfTimes = new int[N];
		sumOfTimes[0] = times[0];
		for(int i=1; i<N; i++) 
			sumOfTimes[i] = sumOfTimes[i-1] + times[i];
		int result = 0;
		for(int i=0; i<N; i++) 
			result += sumOfTimes[i];
					
		System.out.println(result);
	}

}