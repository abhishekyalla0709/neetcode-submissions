class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int odd = expandThroughCenter(s,i,i);
            int even = expandThroughCenter(s,i,i+1);
            int maxlength = Math.max(odd,even);
            if(maxlength>end-start){
                end = i + maxlength/2;
                start = i - (maxlength-1)/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int expandThroughCenter(String s, int left, int right){
        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        return right-left-1;
    }
}
