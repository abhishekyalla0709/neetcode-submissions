class Solution {
    public boolean isPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch) || Character.isUpperCase(ch) || Character.isDigit(ch)){
                ans+=Character.toLowerCase(ch);
            }
        }
        int l = 0;
        int r = ans.length()-1;
        while(l<r){
            if(ans.charAt(l)!=ans.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
