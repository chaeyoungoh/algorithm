import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        List<Book> list = new ArrayList<>();
        for(String key : hm.keySet()) {
            list.add(new Book(key, hm.get(key)));
        }
        Collections.sort(list);
        System.out.println(list.get(0).name);
    }
    static class Book implements Comparable<Book>{
        String name;
        int cnt;
        public Book(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Book o) {
            if(this.cnt == o.cnt)
                return this.name.compareTo(o.name);
            return o.cnt - this.cnt;
        }
    }
}