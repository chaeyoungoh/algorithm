import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge>{
		int idx, weight;

		public Edge(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		final int INF = Integer.MAX_VALUE;
		dis = new int[V+1];
        
		Arrays.fill(dis, INF);
		
		dis[K] = 0;
		
		pq.add(new Edge(K, 0));
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			for(Edge next : graph.get(tmp.idx)) {
				if(dis[next.idx] > dis[tmp.idx] + next.weight) {
					dis[next.idx] = dis[tmp.idx] + next.weight;
					pq.add(new Edge(next.idx, dis[next.idx]));
				}
			}
		}
		
		for (int i = 1; i < V+1; i++) {
			if(dis[i] == INF)
				sb.append("INF").append('\n');
			else
				sb.append(dis[i]).append('\n');
		}
		
	}
	
	static int V, E, K;
	static int[] dis;
	static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<Edge>());
		}

		for(int c = 0; c < E; c++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(s).add(new Edge(e, w));
		}
		
		dijkstra();
		
		System.out.println(sb.toString());
	}
}