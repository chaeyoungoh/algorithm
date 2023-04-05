import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		long[] D = new long[Y+1];
		D[0] = H;
		for(int i=1; i<=Y; i++) {
			D[i] = (long)Math.floor(D[i-1] * 1.05);
			if(i >= 3)
				D[i] = Math.max(D[i], (long)Math.floor(D[i-3] * 1.2));
			if(i >= 5)
				D[i] = Math.max(D[i], (long)Math.floor(D[i-5] * 1.35)); 
		}
		
		System.out.println(D[Y]);
	}

}