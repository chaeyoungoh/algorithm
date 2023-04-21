import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static StringBuilder sb = new StringBuilder();

	private static void ac(List<String> nums, String s) {
		boolean front = true;
		boolean flag = false;
		
		for(char c : s.toCharArray()) {
//			R인 경우
			if(c == 'R') {
				if(front) 
					front = false;
				else
					front = true;
			} else {
				
//			D인 경우
				if(nums.size() == 0) {
					flag = true;
					break;
				}
				
				if(front) {
//					앞에서 삭제
					nums.remove(0);
				} else {
//					뒤에서 삭제
					nums.remove(nums.size()-1);
				}
 			}
		}
		
		if(flag) {
			sb.append("error");
		} else {
			sb.append('[');
			
			if(nums.size() > 0) {			
				if(front) {
//				앞부터 출력
					for(int i=0; i<nums.size()-1; i++) {			
						sb.append(nums.get(i)).append(',');
					}
					sb.append(nums.get(nums.size()-1));				
				} else {
//				뒤부터 출력
					for(int i=nums.size()-1; i>0; i--) {			
						sb.append(nums.get(i)).append(',');
					}
					sb.append(nums.get(0));	
				}
			} 
				
			sb.append(']');				
		}

		sb.append('\n');
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String S = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String ARR = br.readLine();
			
			ARR = ARR.replace("[", "").replace("]", "");
			String[] tmp = ARR.split(",");
			
			List<String> nums = new ArrayList<String>();
			if(N > 0) {
				for(String s : tmp)
					nums.add(s);
			}
			ac(nums, S);
		}
		
		System.out.println(sb.toString());
	}

}