import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        char[] nums = N.toCharArray();

        int sum = 0;
        boolean containZero = false;
        for(int i=0; i<nums.length; i++) {
            int tmp = nums[i] - '0';
            if(tmp == 0)
                containZero = true;
            sum += tmp;
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        if(containZero && sum % 3 == 0) {
            for(int i=0; i<nums.length; i++) {
                sb.append(nums[i]);
            }
            System.out.println(sb.reverse());
        }
        else {
            System.out.println(-1);
        }
    }

}