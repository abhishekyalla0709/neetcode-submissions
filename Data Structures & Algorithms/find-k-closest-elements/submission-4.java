class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // use binary search to find the pos
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==x){
                low=mid;
                break;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        // now low is the position at which x should be placed
        // now we have to make a window by taking left and right
        int left = low-1;
        int right = low;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while(left>=0 && right<arr.length && count<k){
            if(Math.abs(x-arr[left])<=Math.abs(x-arr[right])){
                left--;
            }
            else{
                right++;
            }
            count++;
        }
        while(count<k && left>0){
            left--;
            count++;
        }
        while(count<k && right<arr.length){
            right++;
            count++;
        }
        left++;
        while(left<right){
            list.add(arr[left++]);
        }
        return list;
    }
}