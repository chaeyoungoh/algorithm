import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int L, C, ans;
	static char[] arr;
	static char[] selected;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
//		input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		selected = new char[L];		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++)
			arr[i] = st.nextToken().charAt(0);		
		Arrays.sort(arr);
		
		perm(0, 0, 0, 0);
//		output	
		System.out.print(sb.toString());
	}

	private static void perm(int start, int cnt, int v, int c) {
//		조합 완성 : 조건(자모음 개수) 충족하면 출력하기 
		if(cnt == L) {
			if(v > 0 && c > 1) {
				for (int i = 0; i < selected.length; i++) {
					sb.append(selected[i]);
				}
				sb.append('\n');
			}
			return;
		}
		
//		조합 만들기
		for(int i = start; i < C; i++) {
			selected[cnt] = arr[i];
//			자/모음 파악해서 카운팅 
			if(isVowel(arr[i]))
				perm(i + 1, cnt + 1, v + 1, c);
			else
				perm(i + 1, cnt + 1, v, c + 1);
		}
	}

//	모음인지 체크하기
	private static boolean isVowel(char current) {
		if(current == 'a' || current == 'i' || current == 'u' || current == 'o' || current == 'e')
			return true;
		
		return false;
	}

}