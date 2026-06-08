class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a,b) -> a.get(0)-b.get(0));
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x+y*y;
            List<Integer> list = new ArrayList<>();
            list.add(dist);
            list.add(x);
            list.add(y);
            minHeap.offer(list);
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] arr = new int[2];
            arr[0] = minHeap.peek().get(1);
            arr[1] = minHeap.peek().get(2);
            ans[i] = arr;
            minHeap.poll();
        }
        return ans;
    }
}
