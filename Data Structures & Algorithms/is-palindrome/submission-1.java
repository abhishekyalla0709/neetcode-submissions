class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch) || Character.isUpperCase(ch) || Character.isDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        String s1 = sb.toString();
        int l = 0;
        int r = s1.length()-1;
        while(l<r){
            if(s1.charAt(l)!=s1.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
