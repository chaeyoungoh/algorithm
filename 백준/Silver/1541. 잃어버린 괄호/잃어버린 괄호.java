import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		1. '-' 기준 분리
		String[] sub = br.readLine().split("-");
		
//		2. 연산 
		int sum = Integer.MIN_VALUE;
		for(int i=0; i<sub.length; i++) {
//			2-1. '+' 연산 
			int tmp = 0;
			String[] add = sub[i].split("\\+");
			for(int j=0; j<add.length; j++) 
				tmp += Integer.parseInt(add[j]);
			
//			2-2. '-' 연산 : cf. 첫 번째 합은 빼지 않기
			if(sum == Integer.MIN_VALUE) 
				sum = tmp;
			else 
				sum -= tmp;
			
		}
		
		System.out.println(sum);
	}
}