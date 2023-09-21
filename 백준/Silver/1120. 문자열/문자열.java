import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 == len2) {
            answer = checkDifference(s1, s2);
        }
        else {
            /* s2에 더 긴 걸 배치 */
            String tmp;
            if(len1 > len2) {
                tmp = s1;
                s1 = s2;
                s2 = tmp;
                len1 = s1.length();
                len2 = s2.length();
            }
            int len = len2 - len1 + 1;
            String[] arr = new String[len];
            for(int i=0; i<len; i++) {
                arr[i] = s2.substring(i, len1+i);
            }

//            System.out.println(Arrays.toString(arr));

            int min = Integer.MAX_VALUE;
            int tmpCnt = 0;
            for(int i=0; i<len; i++) {
                tmpCnt = checkDifference(s1, arr[i]);
                min = Math.min(min, tmpCnt);
            }

//            System.out.println("min ::: " + min);
            answer = min;
        }

        System.out.print(answer);
    }

    private static int checkDifference(String s1, String s2) {
        int cnt = 0;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] == arr2[i])  continue;
            cnt++;
        }

        return cnt;
    }
}