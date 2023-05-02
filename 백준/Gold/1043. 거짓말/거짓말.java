import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	
	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		boolean[] KNOW = new boolean[N+1];
		for(int i=0; i<T; i++) {
			KNOW[Integer.parseInt(st.nextToken())] = true;
		}
		
		ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
		for(int i=0; i<M; i++)
			parties.add(new ArrayList<Integer>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			for(int j=0; j<P; j++) {
				parties.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int result = M;
		if(M > 0) {
//			2-1. Union & Find
			parents = new int[N+1];
			for(int i=1; i<=N; i++)
				parents[i] = i;
			
			union(parties);
//			System.out.println(Arrays.toString(parents));
			
//			2-2. Arrange Parents
			KNOW = arrange(KNOW);
			
//			3. Count Parties (can talk)
			result = count(parties, KNOW);
		}
	
		
		System.out.println(result);
	}

	private static void union(ArrayList<ArrayList<Integer>> parties) {
		
		for(int i=0; i<parties.size(); i++) {
			int first = parties.get(i).get(0);
			int firPar = find(first);
			
			for(int j=1; j<parties.get(i).size(); j++) {
				int tmp = parties.get(i).get(j);
				int tmPar = find(tmp);
				
				if(firPar > tmPar)
					parents[firPar] = tmPar;
				else
					parents[tmPar] = firPar;
			}
			
		}
	}

	private static int count(ArrayList<ArrayList<Integer>> parties, boolean[] know) {
		int cnt = 0;
		
		for(int i=0; i<parties.size(); i++) {
			boolean flag = false;
			for(int person : parties.get(i)) {
				int tmPar = find(person);
				if(know[tmPar]) {
					flag = true;
					break;
				}
			}
			
			if(!flag)	cnt++;
		}
		
		return cnt;
	}
	
	private static int find(int cur) {
		if(parents[cur] == cur)
			return cur;
		return 
			parents[cur] = find(parents[cur]);
	}
	
	private static boolean[] arrange(boolean[] know) {
		for(int i=0; i<know.length; i++) {
			if(know[i]) {
				int temPar = find(i);
				know[temPar] = true;
			}
		}
		
		return know;
	}

}