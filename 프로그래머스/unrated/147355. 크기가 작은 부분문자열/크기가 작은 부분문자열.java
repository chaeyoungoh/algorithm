class Solution {
    public int solution(String t, String p) {
        int answer = 0;
       int len = p.length();
        long[] nums = new long[t.length() - len + 1];
        System.out.println("len ::: " + nums.length);
        for(int i=0; i<nums.length; i++) {
           String tmp = t.substring(i, i + len);
           nums[i] = Long.parseLong(tmp);
        }


        long pNum = Long.parseLong(p);
        for(long n : nums) {
            if(n <= pNum)   answer++;
        }
        return answer;
    }
}