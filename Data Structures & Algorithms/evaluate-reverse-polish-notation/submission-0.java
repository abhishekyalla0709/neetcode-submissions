class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                int c=0;
                if(s.equals("+")){
                    c=a+b;
                }
                if(s.equals("-")){
                    c=b-a;
                }
                if(s.equals("/")){
                    c=b/a;
                }
                if(s.equals("*")){
                    c=b*a;
                }
                stack.push(c);
            }
            else{
                int x = Integer.valueOf(s);
                stack.push(x);
            }
        }
        return stack.peek();
    }
}