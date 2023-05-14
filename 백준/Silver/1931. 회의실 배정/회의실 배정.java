import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Room implements Comparable<Room> {
		int s, e;
		public Room(int s, int e) {
			this.s = s;
			this.e = e;
		}
//		e 기준 오름차순 
		@Override
		public int compareTo(Room o) {
			return this.e != o.e ? this.e - o.e : this.s - o.s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Room> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.offer(new Room(s, e));
		}
		
		int answer = scheduling(pq);
		System.out.println(answer);
	}

	private static int scheduling(PriorityQueue<Room> pq) {
		int cnt = 0;
		
		Room tmp = pq.poll();
		int exE = tmp.e;
		cnt++;
		while(!pq.isEmpty()) {
			tmp = pq.poll();
			int s = tmp.s;
			if(s >= exE) {
				cnt++;
				exE = tmp.e;
			}
		}
		
		return cnt;
	}

}