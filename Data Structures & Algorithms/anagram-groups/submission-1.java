class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        String s = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < strs.length; i++){
            int[] arr = new int[26];
            Arrays.fill(arr,-1);
            String s1 = strs[i];
            for(int j = 0; j < s1.length(); j++){
                int x = s.indexOf(s1.charAt(j));
                arr[x]+=1;
                //System.out.println(x + " " + arr[x]);
            }
            //System.out.println(Arrays.toString(arr));
            String s2 = "";
            for(int j = 0; j < 26; j++){
                s2+=arr[j];
            }
            //System.out.println(s2);
            if(map.containsKey(s2)){
                List<String> list = map.get(s2);
                list.add(s1);
                map.put(s2,list);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s1);
                map.put(s2,list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}

//the logic behind in solving this problem is 
// 1st we can convert the string in a particular order like how many times a character appeared
// then we can use it as a key and keep all the values in the given input which matches with these 
// as the List of Strings using hashmap