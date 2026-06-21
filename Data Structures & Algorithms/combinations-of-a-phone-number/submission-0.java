class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }

        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        StringBuilder sb = new StringBuilder();
        backTrack(digits,0,sb,map,ans);
        return ans;
    }

    private void backTrack(String digits, int index, StringBuilder sb, Map<Integer,String> map, List<String> ans){
            if(sb.length()==digits.length()){
                ans.add(sb.toString());
                return;
            }
            if(index==digits.length()){
                return;
            }
            int num = Character.getNumericValue(digits.charAt(index));
            String s = map.get(num);
            for(int i = 0; i < s.length(); i++){
                sb.append(s.charAt(i));
                backTrack(digits,index+1,sb,map,ans);
                sb.deleteCharAt(sb.length()-1);
            }
            return;
        }
    
}
