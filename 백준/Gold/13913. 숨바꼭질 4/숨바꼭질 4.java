import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] before;
    static StringBuilder sb = new StringBuilder();

    static class Point {
        int location, cnt;
        public Point(int location, int cnt) {
            this.location = location;
            this.cnt = cnt;
        }
    }

    private static Point solution(int s, int e) {
        Queue<Point> que = new LinkedList<>();
        boolean[] vis = new boolean[100001];
        before = new int[100001];

        que.offer(new Point(s, 0));
        vis[s] = true;
        before[s] = -1;

        while(!que.isEmpty()) {
            Point cur = que.poll();
            int loc = cur.location;
            int cnt = cur.cnt;

            if(loc == e)    return cur;

            if(loc+1<=100000 && !vis[loc+1]) {
               que.offer(new Point(loc+1, cnt+1));
               vis[loc+1] = true;
               before[loc+1] = loc;
            }
            if(loc-1>=0 && !vis[loc-1]) {
                que.offer(new Point(loc-1, cnt+1));
                vis[loc-1] = true;
                before[loc-1] = loc;
            }
            if(loc*2<=100000 && !vis[loc*2]) {
                que.offer(new Point(loc*2, cnt+1));
                vis[loc*2] = true;
                before[loc*2] = loc;
            }

        }
        return null;
    }

    private static void getAnswer(Point result) {
        Stack<Integer> stack = new Stack<>();
        int tmp = result.location;
        sb.append(result.cnt).append('\n');
        while(tmp != -1) {
            stack.push(tmp);
            tmp = before[tmp];
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Point result = solution(S, E);

        getAnswer(result);
        
        System.out.println(sb.toString());
    }
}