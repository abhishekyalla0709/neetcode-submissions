class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        partition(s,wordDict,ans,0,list);
        return ans;
    }

    private void partition(String s, List<String> wordDict, List<String> ans, int index, List<String> list){
        if(index==s.length()){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < list.size(); i++){
                sb.append(list.get(i)+" ");
            }
            sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
            return;
        }
        for(int i = index; i < s.length(); i++){
            String str = s.substring(index,i+1);
            if(wordDict.contains(str)){
                list.add(str);
                partition(s,wordDict,ans,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
}