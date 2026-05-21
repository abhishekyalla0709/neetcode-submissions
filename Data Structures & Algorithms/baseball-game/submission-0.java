class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < operations.length; i++){
            String s = operations[i];
            if(s.equals("C")){
                stack.pop();
            }
            else if(s.equals("D")){
                stack.push(2*stack.peek());
            }
            else if(s.equals("+")){
                int x = stack.peek();
                stack.pop();
                int y = stack.peek();
                stack.push(x);
                stack.push(x+y);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans+=stack.peek();
            stack.pop();
        }
        return ans;
    }
}