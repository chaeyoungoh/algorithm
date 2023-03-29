import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Person implements Comparable<Person>{
		int idx, age;
		String name;
		public Person(int idx, int age, String name) {
			super();
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Person o) {
			return this.age == o.age ? this.idx - o.idx : this.age - o.age;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Person> que = new PriorityQueue<>();
		StringTokenizer st;
		for(int c=0; c<N; c++) {
			st = new StringTokenizer(br.readLine());
			que.add(new Person(c, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		for(int c=0; c<N; c++) {
			Person cur = que.poll();
			sb.append(cur.age).append(' ').append(cur.name).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}