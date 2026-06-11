class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        int l = 0;
        int r = 0;
        Map<Character,Integer> map2 = new HashMap<>();
        while(r<s2.length()){
            char ch = s2.charAt(r++);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if(!map1.containsKey(ch)){
                while(l<r){
                    char ch1 = s2.charAt(l++);
                    map2.put(ch1,map2.get(ch1)-1);
                }
            }
            if(r-l==s1.length()){
                boolean flag = true;
                for(Map.Entry<Character,Integer> entry : map1.entrySet()){
                    char ch1 = entry.getKey();
                    int val = entry.getValue();
                    if(map2.containsKey(ch1) && map2.get(ch1)!=val){
                        flag = false;
                        map2.put(s2.charAt(l),map2.get(s2.charAt(l))-1);
                        l++;
                    }
                }
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
}
