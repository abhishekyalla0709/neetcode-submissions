class Solution {
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < path.length(); i++){
            char ch = path.charAt(i);
            if(ch!='/'){
                sb.append(ch);
            }
            else{
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        if(sb.length()!=0){
            list.add(sb.toString());
        }
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);
            if(s.equals("")){
                continue;
            }
            else if(s.equals(".")){
                continue;
            }
            else if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(s);
            }
        }
        List<String> list1 = new ArrayList<>();
        while(!stack.isEmpty()){
            list1.add(stack.pop());
        }
        StringBuilder ans = new StringBuilder();
        for(int i = list1.size()-1; i >=0; i--){
            ans.append("/");
            ans.append(list1.get(i));
        }
        if(ans.length()==0){
            return "/";
        }
        System.out.println(list);
        return ans.toString();
    }
}