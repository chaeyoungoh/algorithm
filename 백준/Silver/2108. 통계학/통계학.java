import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i=0; i<N; i++)
            nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        /* 산술평균 */
        double sum = 0;
        for(int i=0; i<N; i++)
            sum += nums[i];
        int avg = (int) Math.round(sum / N);
        sb.append(avg).append('\n');

        /* 중앙값 */
        sb.append(nums[N/2]).append('\n');

        /* 최빈값 */
        int val = 0;
        int max = -1;
        int[] count = new int[8001];
        for(int i=0; i<N; i++) {
            int cur = nums[i] + 4000;
            count[cur]++;
            if(max < count[cur]) {
                max = count[cur];
                val = cur - 4000;
            }
        }

        int tmp = 0;
        for(int i=0; i<8001; i++) {
            if(max == count[i]) tmp++;
            if(tmp == 2) {
                val = i- 4000;
                break;
            }
        }
        sb.append(val).append('\n');

        /* 범위 */
        int bound = nums[N-1] - nums[0];
        sb.append(bound);

        System.out.println(sb.toString());
    }
}