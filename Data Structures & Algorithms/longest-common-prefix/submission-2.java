class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strs[0]);
        for(int i = 1; i < strs.length; i++){
            String s = strs[i];
            int p = s.length();
            int q = sb.length();
            if(q>p){
                sb.delete(p,q);
            }
            int min = Math.min(p,q);
            for(int j = 0; j < min; j++){
                if(sb.charAt(j)!=s.charAt(j)){
                    sb.delete(j,q);
                    break;
                }
            }
            if(sb.length()==0){
                break;
            }            
        }
        return sb.toString();
    }
}