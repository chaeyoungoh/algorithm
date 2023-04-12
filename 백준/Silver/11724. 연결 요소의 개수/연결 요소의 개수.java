import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, parents[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		makeSet();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
		
			union(s, e);
		}
		
		int ans = 0;
		for (int i = 1; i < N+1; i++) {
			if(find(i) == i) ans++;
		}
		
		System.out.println(ans);
	}

	private static void makeSet() {
		parents = new int[N+1];

		for (int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot > bRoot) 
			parents[aRoot] = bRoot;
		else
			parents[bRoot] = aRoot;
			
	}

	private static int find(int x) {
		if(parents[x] == x) 
			return x;
		
		return parents[x] = find(parents[x]);
	}

}