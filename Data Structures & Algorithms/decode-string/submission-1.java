class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch) && stack.isEmpty()){
                ans.append(ch);
            }
            else {
                if(ch!=']'){
                    stack.push(ch+"");
                }
                else{
                    StringBuilder sb = new StringBuilder();
                    int freq = 1;
                    while(!stack.isEmpty()){
                        String top = stack.pop();
                        if(top.equals("[")){
                            StringBuilder sb3 = new StringBuilder();
                            while(!stack.isEmpty()){
                                String s1 = stack.peek();
                                if(s1.charAt(0)-'0'<=9){
                                    sb3.insert(0,s1);
                                    stack.pop();
                                }
                                else{
                                    break;
                                }
                            }
                            freq = Integer.parseInt(sb3.toString());
                            break;
                        }
                        else{
                            sb.insert(0,top);
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for(int j = 0; j <freq; j++){
                        sb2.append(sb);
                    }
                    if(!stack.isEmpty()){
                        stack.push(sb2.toString());
                    }
                    else{
                        ans.append(sb2);
                    }
                }
            }
        }
        return ans.toString();
    }
}