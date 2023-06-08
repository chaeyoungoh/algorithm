import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int S, E;
	static boolean[] justNums;
	
	public static void main(String[] args) throws IOException {
		StringBuilder result = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		justNums = new boolean[E+1];
		isPrime();
		for(int i=S; i<=E; i++) {
			if(justNums[i])	
				continue;
			else	
				result.append(i).append('\n');
		}
		
		System.out.println(result.toString());
	}

	private static void isPrime() {
		justNums[0] = justNums[1] = true;
		
		for(int i=2; i<=Math.sqrt(E); i++) {
			if(justNums[i])	continue;
			for(int j=i*2; j<=E; j+=i)
				justNums[j] = true;
		}
			
	}

}