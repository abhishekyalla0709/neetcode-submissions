class Solution {
    public int countSubstrings(String s) {
        int total_count = 0;
        for(int i = 0; i < s.length(); i++){
            int odd = expandThroughCenter(s,i,i);
            int even = expandThroughCenter(s,i,i+1);
            total_count+=odd+even;
        }
        return total_count;
    }

    private int expandThroughCenter(String s, int left, int right){
        int ans = 0;
        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }
            left--;
            right++;
            ans++;
        }
        return ans;
    }
}
