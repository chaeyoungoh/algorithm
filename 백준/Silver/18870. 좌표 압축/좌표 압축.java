import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            set.add(nums[i]);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int idx = 0;
        for(Integer i : set)
            hm.put(i, idx++);
        for(int i=0; i<N; i++)
           sb.append(hm.get(nums[i])).append(' ');
        System.out.println(sb.toString());
    }
}