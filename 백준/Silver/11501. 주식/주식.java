import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Stock implements Comparable<Stock> {
        int idx;
        int val;
        public Stock(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Stock o) {
            return o.val - this.val;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                nums[i] = Integer.parseInt(st.nextToken());

            long profit = getMaxProfit(N, nums);

            sb.append(profit).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static long getMaxProfit(int n, int[] nums) {
        long result = 0;

        PriorityQueue<Stock> pq = new PriorityQueue<>();
        Queue<Stock> ad = new LinkedList<>();
        for(int i=0; i<n; i++) {
            pq.offer(new Stock(i, nums[i]));
            ad.offer(new Stock(i, nums[i]));
        }

        while(!pq.isEmpty()) {
            Stock max = pq.poll();
            int len = ad.size();
            for(int i=1; i<=len; i++) {
                Stock min = ad.poll();
                if(max.idx >= min.idx) {
                    result += (max.val - min.val);
                }
                else {
                    ad.offer(min);
                }
            }
        }

        return result;
    }
}