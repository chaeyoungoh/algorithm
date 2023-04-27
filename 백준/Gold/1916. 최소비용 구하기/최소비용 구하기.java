import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int e, c;
		public Node(int e, int c) {
			this.e = e;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 도시 개수
		int M = Integer.parseInt(br.readLine());	// 버스 개수
		StringTokenizer st;
		
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int ns = Integer.parseInt(st.nextToken());
			int ne = Integer.parseInt(st.nextToken());
			int nc = Integer.parseInt(st.nextToken());
			list.get(ns).add(new Node(ne, nc));
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int answer = calcCost(list, s, e, N);
		System.out.println(answer);
	}

	private static int calcCost(ArrayList<ArrayList<Node>> list, int start, int end, int N) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		int[] dis = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dis, INF);

		dis[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int	x = tmp.e;

			if(visited[x]) continue;
			visited[x] = true;
			for(Node next : list.get(x)) {
				int nx = next.e;
				int nc = next.c;
				if(visited[nx]) continue;
				if(dis[nx] > dis[x] + nc) {
					dis[nx] = dis[x] + nc;
					pq.offer(new Node(nx, dis[nx]));
				}
			}
		}
		
		return dis[end];
	}

}