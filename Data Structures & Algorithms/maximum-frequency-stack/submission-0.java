class FreqStack {

    Map<Integer,Integer> countMap = new HashMap<>();
    Map<Integer,Deque<Integer>> freqMap = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {
        
    }
    
    public void push(int val) {
        int freq = countMap.getOrDefault(val,0) + 1;
        countMap.put(val,freq);
        maxFreq = Math.max(maxFreq,freq);
        // inserting in freqMap
        if(freqMap.containsKey(freq)){
            Deque<Integer> stack = freqMap.get(freq);
            stack.push(val);
            freqMap.put(freq,stack);
        }
        else{
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(val);
            freqMap.put(freq,stack);
        }
    }
    
    public int pop() {
        Deque<Integer> stack = freqMap.get(maxFreq);
        int ans = stack.pop();
        countMap.put(ans,countMap.get(ans)-1);
        if(stack.isEmpty()){
            maxFreq--;
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */