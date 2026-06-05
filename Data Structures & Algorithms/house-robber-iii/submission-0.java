/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] ans = DFS(root);
        return Math.max(ans[0],ans[1]);
    }

    private int[] DFS(TreeNode root){
        if(root==null){
            int[] arr = new int[2];
            arr[0] = 0;
            arr[1] = 0;
            return arr;
        }
        int[] left = DFS(root.left);
        int[] right = DFS(root.right);
        // if this node is selected then
        int[] temp = new int[2];
        temp[0] = root.val + left[1] + right[1];
        // if this node not selected then
        temp[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return temp;
    }
}