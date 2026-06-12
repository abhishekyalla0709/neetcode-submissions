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

        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(!map1.containsKey(ch)){
                return false;
            }
            map1.put(ch,map1.get(ch)-1);
        }

        for(Map.Entry<Character,Integer> entry : map1.entrySet()){
            char ch = entry.getKey();
            int val = entry.getValue();
            if(val!=0){
                return false;
            }
        }
        return true;
    }
}
