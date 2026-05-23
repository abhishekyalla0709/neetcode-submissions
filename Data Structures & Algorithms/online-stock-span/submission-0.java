class StockSpanner {

    private Stack<int[]> stack;
    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            int[] arr = stack.pop();
            ans+=arr[1];
        }
        int[] arr = new int[2];
        arr[0] = price;
        arr[1] = ans;
        stack.push(arr);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */