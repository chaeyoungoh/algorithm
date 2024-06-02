import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int index, value;
        public Point(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static LinkedList<Integer> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // input
        Deque<Point> dq = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            dq.add(new Point(i, tmp));
        }

        start(dq);
        for(int i : result)
            System.out.print(i + " ");
    }
    private static void start(Deque<Point> dq) {
        // first
        Point cur = dq.poll();
        result.add(cur.index);
        int curVal = cur.value;
        Point nx;

        while(!dq.isEmpty()) {
            if (curVal > 0) {
                for (int i = 0; i < curVal - 1; i++) {
                    nx = dq.pollFirst();
                    dq.offerLast(nx);
                }
                nx = dq.poll();
            }
            else {
                for (int i = curVal + 1; i < 0; i++) {
                    nx = dq.pollLast();
                    dq.offerFirst(nx);
                }
                nx = dq.pollLast();
            }
            result.add(nx.index);
            curVal = nx.value;
        }
    }
}