import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
N 중 M개 뽑기
조합(중복o)
Set :  중복 제거
비오름차순
 */
public class Main {
    static int N, M;
    static int[] nums, sel;
    static ArrayList<Integer> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        sel = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);

        list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] == nums[i])    continue;
            list.add(nums[i]);
        }

        combi(0, 0);
        
        System.out.print(sb.toString());

    }

    public static void combi(int cnt, int s) {
        if(cnt == M) {
            for(int i : sel) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=s; i<list.size(); i++) {
            sel[cnt] = list.get(i);
            combi(cnt+1, i);
        }
    }
}