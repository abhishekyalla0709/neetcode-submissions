class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1],b[1]));
        int cap = 0;
        int dist = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int i = 0; i < trips.length; i++){
            dist=trips[i][1];
            while(!minHeap.isEmpty() && minHeap.peek()[2]<=dist){
                cap-=minHeap.poll()[0];
            }
            cap+=trips[i][0];
            if(cap > capacity){
                return false;
            }
            minHeap.offer(trips[i]);
        }
        return true;
    }
}