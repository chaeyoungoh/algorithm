import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[][] friends = new boolean[N][N];
		boolean[][] influ = new boolean[N][N];
		
//		배열 입력받기
//		StringTokenizer st;
		for(int i=0; i<N; i++) {
//			st = new StringTokenizer(br.readLine());
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				char cur = s.charAt(j);
				if(cur == 'Y') 
					friends[i][j] = true;
			}
		}
		
//		새 친구 찾기 : 친구의 친구
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(friends[i][j]) {
					influ[i][j] = true;
//					친구의 친구 찾으러 가기
					for(int k=0; k<N; k++) {
						if(i == k) continue;
						if(friends[j][k]) {
							influ[i][k] = true;
						}
					}	
				}
				
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if(influ[i][j])	cnt++;
			}
			max = Math.max(max, cnt);
		}
	
		System.out.println(max);
//		System.out.println(Arrays.deepToString(friends));
	}

}