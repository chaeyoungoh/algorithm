import java.util.*;
    
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
        
       String[] tmp = s.split(" ");
		for(String str : tmp) {
			list.add(Integer.parseInt(str));
		}
		
		Collections.sort(list);
		
		sb.append(list.get(0)).append(' ').append(list.get(list.size() - 1));
        return sb.toString();
    }
}