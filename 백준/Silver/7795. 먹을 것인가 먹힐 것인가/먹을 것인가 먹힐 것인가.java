import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] arr = new int[a];
            int[] brr = new int[b];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<a; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<b; i++)
                brr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            Arrays.sort(brr);

            sb.append(solution(arr, brr)).append('\n');
        }

        System.out.print(sb.toString());
    }
    public static int solution(int[] arr, int[] brr) {
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            cnt += search(0, brr.length-1, arr[i], brr);
        }
        return cnt;
    }
    public static int search(int start, int end, int a, int[] brr) {
        int mid = 0;
       while(start <= end) {
           mid = (start + end) / 2;
           if(a > brr[mid])
                start = mid + 1;
           else
                end = mid - 1;
       }
       return start;
    }
}