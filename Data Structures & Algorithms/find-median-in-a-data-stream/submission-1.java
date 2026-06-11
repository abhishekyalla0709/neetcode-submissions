class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    }
    // maxHeap will be towards left
    // minHeap will be towards right half of array
    public void addNum(int num) {
        if(minHeap.size()==maxHeap.size()){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else if(minHeap.size()>maxHeap.size()){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (double) (minHeap.peek()+maxHeap.peek())/2;
        }
        else if(minHeap.size()>maxHeap.size()){
            return (double) minHeap.peek();
        }
        else{
            return (double) maxHeap.peek();
        }
    }
}
