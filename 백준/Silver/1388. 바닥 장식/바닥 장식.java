import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] floor = new char[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                floor[i][j] = s.charAt(j);
            }
        }

        System.out.println(check(floor, N, M));
    }
    public static int check(char[][] map, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j])   continue;
                visited[i][j] = true;
                cnt++;
                char cur = map[i][j];
                if(cur == '-') {
                    for(int k=j; k<m; k++) {
                        if(map[i][k] == cur)
                            visited[i][k] = true;
                        else
                            break;
                    }
                }
                else {
                    for(int k=i; k<n; k++) {
                        if(map[k][j] == cur)
                            visited[k][j] = true;
                        else
                            break;
                    }
                }
            }
        }
        return cnt;
    }
}