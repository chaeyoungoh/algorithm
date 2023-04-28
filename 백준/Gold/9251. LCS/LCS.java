import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();

		int len1 = s1.length() + 1;
		int len2 = s2.length() + 1;
		char[] c1 = new char[len1];
		char[] c2 = new char[len2];
		for(int i=1; i<len1; i++) 
			c1[i] = s1.charAt(i-1);
		for(int i=1; i<len2; i++) 
			c2[i] = s2.charAt(i-1);
		

		int[][] LCS = new int[len1][len2];

		for(int i=1; i<len1; i++) {
			for(int j=1; j<len2; j++) {
				if(c1[i] == c2[j]) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
				}
				else {
					LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
				}
			}
		}


		System.out.println(LCS[len1-1][len2-1]);
	}

}