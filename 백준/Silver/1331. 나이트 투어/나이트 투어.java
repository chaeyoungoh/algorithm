import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static boolean isValid(String s, boolean[][] visited, int[] pre) {
//		s(String)를 행, 열(int)로 바꾸기
		int r = s.charAt(0) - 'A';
		int c = s.charAt(1) - '1';
//		방문 여부 체크
//		갈 수 있음 : 방문한 적 없음 + 나이트가 갈 수 있는 영역
		if(!visited[r][c] && canGo(r, c, pre)) {
			visited[r][c] = true;
			pre[0] = r;
			pre[1] = c;
			return true;
		} else {
//			갈 수 없음
			return false;
		}
	}
	
	private static boolean canGo(int r, int c, int[] pre) {
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

		for(int d=0; d<dx.length; d++) {
			if(r == pre[0] + dx[d] && c == pre[1] + dy[d])
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] visited = new boolean[6][6];
		String ans = "Valid";
		int[] start = new int[2];
		int[] pre = new int[2];
		
//		시작점 세팅 
		String s = br.readLine();
		int sr = s.charAt(0) - 'A';
		int sc = s.charAt(1) - '1';
		start[0] = pre[0] = sr;
		start[1] = pre[1] = sc;
		visited[sr][sc] = true;
		
//		35개 체크
		boolean flag = false;
		for(int c=1; c<36; c++) {
			s = br.readLine();
			flag = isValid(s, visited, pre);
			if(!flag) {
				ans = "Invalid";
				break;
			}
		}
//		마지막 -> 처음
		if(flag) {
			if(!canGo(start[0], start[1], pre))
				ans = "Invalid";
		}
		
		System.out.println(ans);
	}

}