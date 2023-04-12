import java.util.*;

class Solution {
    
    static int max;
    static int[] selected;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        selected = new int[dungeons.length];
	    visited = new boolean[dungeons.length];
		perm(0, k, dungeons);
        
        return max;
    }
    
    private static void perm(int cnt, int k, int[][] map) {
		if(cnt == map.length) {
//			System.out.println(Arrays.toString(selected));
			calc(selected, k, map);
		}
		
		for(int i=0; i<map.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[cnt] = i;
			perm(cnt+1, k, map);
			visited[i] = false;
		}
	}

	private static void calc(int[] selected, int k, int[][] map) {
		int hp = k;
		int cnt = 0;
		for(int i=0; i<selected.length; i++) {
			int cur = selected[i];
			if(map[cur][0] > hp) break;
			hp -= map[cur][1];
			cnt++;
		}
		
		max = Math.max(max, cnt);
	}
}