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
        maxHeap.add(num);
        if (
            maxHeap.size() - minHeap.size() > 1 ||
            !minHeap.isEmpty() &&
            maxHeap.peek() > minHeap.peek()
        ) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
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
