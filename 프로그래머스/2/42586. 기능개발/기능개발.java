import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answers = new ArrayList<>();
        
        int len = progresses.length;
        int[] days = new int[len];
        for(int i=0; i<len; i++) {
            int mod = (100 - progresses[i] ) % speeds[i];
            if(mod == 0) {
                days[i] = (100 - progresses[i] ) / speeds[i];
            }
            else {
                days[i] = (100 - progresses[i] ) / speeds[i] + 1;
            }
        }
        
        boolean[] vis = new boolean[len];
        for(int i=0; i<len; i++) {
            if(vis[i])  continue;
            vis[i] = true;
            int day = days[i];
           int cnt = 0;
           
           for(int j=i; j<len; j++) {
               if(day >= days[j])   {
                   vis[j] = true;
                   cnt++;
               }
                else    {
                    break;
                }
           }
        answers.add(cnt);

       }
        
        return answers;
    }
}