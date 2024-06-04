import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // input
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(s.length() < M)  continue;
            hm.put(s, hm.getOrDefault(s, 1) + 1);
        }
        // sort
       List<Word> list = new ArrayList<>();
        for(String key : hm.keySet()) {
            Word tmp = new Word(key, hm.get(key));
            list.add(tmp);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(Word w : list) {
            sb.append(w.name).append('\n');
        }
        System.out.println(sb.toString());
    }
    static class Word implements Comparable<Word> {
        String name;
        int cnt;
        public Word(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Word o) {
            if(this.cnt != o.cnt) {
                return o.cnt - this.cnt;
            }
            if(this.name.length() != o.name.length()) {
                return o.name.length() - this.name.length();
            }
            return this.name.compareTo(o.name);
        }
    }
}