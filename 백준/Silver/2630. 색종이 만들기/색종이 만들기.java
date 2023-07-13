import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int white, blue;
    
    private static void cut(int r, int c, int size) {
        int s = map[r][c];
        int cnt = 0;
        for(int i=r; i<r+size; i++) {
            for(int j=c; j<c+size; j++) {
                if(map[i][j] == s)
                    cnt += map[i][j];
                else {
                    size /= 2;
                    cut(r, c, size);
                    cut(r, c + size, size);
                    cut(r + size, c, size);
                    cut(r + size, c+size, size);
                    return;
                }
            }
        }
        if(cnt == size * size)
            blue++;
        else if(cnt == 0)
            white++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }
}