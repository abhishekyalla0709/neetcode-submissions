class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // iterate from backwards and place the last element in back
        int p = m+n-1;
        int p1 = m-1;
        int p2 = n-1;
        while(p2>=0 && p1>=0){
            if(nums1[p1]<=nums2[p2]){
                nums1[p--] = nums2[p2--];
            }
            else{
                nums1[p--] = nums1[p1--];
            }
        }
        while(p1>=0){
            nums1[p--] = nums1[p1--];
        }
        while(p2>=0){
            nums1[p--] = nums2[p2--];
        }
    }
}