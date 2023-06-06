import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
//	Hash set

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> hmd = new HashMap<>();		
		for(int i=0;i<N; i++) {
			hmd.put(br.readLine(), 1);
		}
		
		String[] arrb = new String[M];
		for(int i=0;i<M; i++) 
			arrb[i] = br.readLine();
		Arrays.sort(arrb);
		
		int cnt = 0;
		for(String tmp : arrb) {
			if(hmd.containsKey(tmp)) {
				cnt++;
				sb.append(tmp).append('\n');
			}
		}	
		
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

}