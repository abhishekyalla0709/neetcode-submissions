class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(r<s.length()){
            char ch = s.charAt(r++);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.containsKey(ch) && map.get(ch)>1){
                ans = Math.max(ans,(r-l-1));
                while(map.get(ch)>1){
                    char ch1 = s.charAt(l++);
                    map.put(ch1,map.get(ch1)-1);
                }
            }
            
        }
        ans=Math.max(ans,(r-l));
        return ans;
    }
}
