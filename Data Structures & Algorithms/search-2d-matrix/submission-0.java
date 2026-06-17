class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row*col-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int rows = mid/col;
            int cols = mid%col;
            if(matrix[rows][cols]==target){
                return true;
            }
            else if(matrix[rows][cols]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
}
