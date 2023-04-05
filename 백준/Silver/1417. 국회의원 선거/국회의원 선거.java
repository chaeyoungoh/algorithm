import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int me = Integer.parseInt(br.readLine());
		int cnt = 0;

		if(N > 1) {
			int[] candi = new int[N-1];
			for(int i=0; i<N-1; i++) {
				candi[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(candi);
			int max = candi[N-2];
			while(me <= max) {
				cnt++;
				me++;
				candi[N-2]--;
				Arrays.sort(candi);
				max = candi[N-2];
			}
		}
		
		System.out.println(cnt);
	}

}