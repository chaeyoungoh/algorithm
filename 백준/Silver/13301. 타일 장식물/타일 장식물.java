import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] L = new long[N+1];
		long[] Cir = new long[N+1];
		
		L[1] = 1;
		Cir[1] = 4;
		
		for(int i=2; i<=N; i++) {
			L[i] = L[i-1] + L[i-2];
			Cir[i] = Cir[i-1] + (L[i] * 2);
		}
		
		System.out.println(Cir[N]);
	}

}