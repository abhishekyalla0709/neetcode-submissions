class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a1,b1) -> Integer.compare(b1[0],a1[0]));
        if(a!=0){
            int[] arr = new int[2];
            arr[0] = a;
            arr[1] = 'a';
            maxHeap.offer(arr);
        }
        if(b!=0){
            int[] arr = new int[2];
            arr[0] = b;
            arr[1] = 'b';
            maxHeap.offer(arr);
        }
        if(c!=0){
            int[] arr = new int[2];
            arr[0] = c;
            arr[1] = 'c';
            maxHeap.offer(arr);
        }
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            int[] first = maxHeap.poll();
            if(sb.length()>1 && sb.charAt(sb.length()-1)==first[1] && sb.charAt(sb.length()-2)==first[1]){
                if(maxHeap.isEmpty()){
                    break;
                }
                int[] second = maxHeap.poll();
                sb.append((char) second[1]);
                second[0] = second[0]-1;
                if(second[0]>0){
                    maxHeap.offer(second);
                }
                maxHeap.offer(first);
            }
            else{
                sb.append((char) first[1]);
                first[0] = first[0]-1;
                if(first[0]>0){
                    maxHeap.offer(first);
                }
            }
        }
        return sb.toString(); 
    }
}