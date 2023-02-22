import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		map = new int[N][N];

		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) 
				map[i][j] = Character.getNumericValue(str.charAt(j));
		}
        
		dfs(0, 0, N);
		System.out.println(sb.toString());
	}

	private static void dfs(int r, int c, int size) {

		int zero = 0, one = 0, sum = 0;
		
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				sum += map[i][j];
			}
		}
		
		if(sum == 0)
			sb.append("0");
		else if(sum == size * size)
			sb.append("1");
		else {
			sb.append("(");
			int half = size / 2;
			dfs(r, c, half);
			dfs(r, c + half, half);
			dfs(r + half, c, half);
			dfs(r + half, c + half, half);
			sb.append(")");
		}
			
	}

}