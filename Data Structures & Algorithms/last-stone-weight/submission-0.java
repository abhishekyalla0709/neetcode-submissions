class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((a,b) -> b-a));
        for(int i = 0; i < stones.length; i++){
            maxHeap.offer(stones[i]);
        }
        while(maxHeap.size()>1){
            int x = maxHeap.poll();
            int y = 0;
            if(maxHeap.size()!=0){
                y=maxHeap.poll();
            }
            int a = Math.abs(x-y);
            if(a!=0){
                maxHeap.offer(a);
            }
        }
        if(maxHeap.size()==0){
            return 0;
        }
        return maxHeap.poll();
    }
}
