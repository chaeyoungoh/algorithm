import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, cntS, cntD;
	static char[][] mapS, mapD;
	static boolean[][] selectedS, selectedD;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
//		input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		selectedD = new boolean[N][N];
		mapD = new char[N][N];

		selectedS = new boolean[N][N];
		mapS = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				mapD[i][j] = s.charAt(j);
				if(s.charAt(j) == 'G')
					mapS[i][j] = 'R';
				else {
					mapS[i][j] = s.charAt(j);
				}
			}
		}			

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!selectedS[i][j]) {
					same(i, j);
					cntS++;	
				}
				if(!selectedD[i][j]) {
					diff(i, j);
					cntD++;
					
				}
			}
		}
		
		System.out.println(cntD + " " + cntS);
		
	}
	
//	1. RedIsNotGreen (Diff)
	private static void diff(int r, int c) {		
		selectedD[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			
			if(outOfRange(nx, ny) || selectedD[nx][ny]) continue;
			
			if(mapD[nx][ny] == mapD[r][c]) {
				diff(nx, ny);
			} 
		}
	}
	
//	2. RedIsGreen (Same)
	private static void same(int r, int c) {
		selectedS[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			
			if(outOfRange(nx, ny) || selectedS[nx][ny]) continue;
			
			if(mapS[nx][ny] == mapS[r][c]) {
				same(nx, ny);
			} 
		}
	}
	
	private static boolean outOfRange(int nx, int ny) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= N)
			return true;
		return false;
	}

}