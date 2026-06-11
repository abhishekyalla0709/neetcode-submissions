class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] arr = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int p = 0;
        int complete = 1;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        while (complete <= k) {
            if(p<arr.length  && w< arr[p][0] && maxHeap.isEmpty()){
                break;
            }
            while (p < arr.length && w >= arr[p][0]) {
                maxHeap.offer(arr[p]);
                p++;
            }
            if (!maxHeap.isEmpty()) {
                w += maxHeap.poll()[1];
                complete++;
            }
        }
        return w;
    }
}