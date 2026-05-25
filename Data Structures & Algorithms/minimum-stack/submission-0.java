class MinStack {
    Deque<int[]> stack = new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        int min;
        if(stack.isEmpty()){
            min = val;
        }
        else{
            min = Math.min(val,stack.peek()[1]);
        }
        int[] arr = new int[2];
        arr[0] = val;
        arr[1] = min;
        stack.push(arr);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */