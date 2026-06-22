class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        palindromePartition(s,ans,0,list);
        return ans;
    }

    private void palindromePartition(String s, List<List<String>> ans, int index, List<String> list){
        if(index==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < s.length(); i++){
            String str = s.substring(index, i+1);
            if(isPalindrome(str)){
                list.add(str);
                palindromePartition(s,ans,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
