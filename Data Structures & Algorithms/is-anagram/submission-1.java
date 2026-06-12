class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map1.containsKey(ch)){
                map1.put(ch,map1.get(ch)+1);
            }
            else{
                map1.put(ch,1);
            }
        }

        Map<Character,Integer> map2 = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(map2.containsKey(ch)){
                map2.put(ch,map2.get(ch)+1);
            }
            else{
                map2.put(ch,1);
            }
        }

        for(Map.Entry<Character,Integer> entry : map1.entrySet()){
            char ch = entry.getKey();
            int val = entry.getValue();
            if(!map2.containsKey(ch)){
                return false;
            }
            if(map2.get(ch)!=val){
                return false;
            }
        }
        return true;
    }
}
