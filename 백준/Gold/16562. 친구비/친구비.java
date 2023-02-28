import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static void makeSet() {
		parents = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
//		친구비 적게 드는 사람을 집합의 대표자로 선정하기.
		if(money[aRoot] > money[bRoot])
			parents[aRoot] = bRoot;
		else
			parents[bRoot] = aRoot;
	}
	
	static int N, M, K;
	static int[] parents, money;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		money = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		makeSet();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			union(v, w);
		}
		
		boolean[] rep = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			int tmp = find(i);
			rep[tmp] = true;
		}

		int sum = 0;
		for(int i = 1; i <= N; i++) {
			if(rep[i])
				sum += money[i];
		}

		if(sum <= K)
			System.out.println(sum);
		else
			System.out.println("Oh no");
	}


}