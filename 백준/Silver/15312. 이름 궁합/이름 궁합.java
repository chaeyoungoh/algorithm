import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alp = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		
		String me = br.readLine();
		String her = br.readLine();
		
		int L = me.length() * 2;
		int[] arr = new int[L];
		
		for(int i=0; i<L/2; i++) {
			arr[i * 2] = alp[me.charAt(i) - 'A'];
			arr[i * 2 + 1] = alp[her.charAt(i) - 'A'];
		}
		
		int len = L;
		while(len > 2) {
			len--;
			for(int i=0; i<len; i++) {
				arr[i] += arr[i+1];
				if(arr[i] >= 10)
					arr[i] %= 10;
			} 
		}

		System.out.print(arr[0]);
		System.out.print(arr[1]);
	}
}