class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        this.queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        // this adds element at last pos of queue
        queue.add(x);

        // but we want to add like stack meaning it should come to start pos
        // what this is doing is removes the 1st element adds to last until we reach the added element
        // ex -> 1, 2, 3  -------  3, 1, 2
        for(int i = 0; i< queue.size()-1; i++){
            queue.add(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */