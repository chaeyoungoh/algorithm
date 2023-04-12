import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i : tangerine) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		
		List<Integer> list = new ArrayList<>(hm.values());
		Collections.sort(list, Collections.reverseOrder());
        
		int sum = 0;
		int cnt = 0;
		for(Integer i : list) {
			cnt++;
			sum += i;
			if(sum >= k) break;
		}
        
        return cnt;
    }
}