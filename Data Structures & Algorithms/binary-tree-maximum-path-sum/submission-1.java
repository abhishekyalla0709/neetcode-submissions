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
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        DFS(root);
        return ans;
    }

    private int DFS(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0,DFS(root.left));
        int right = Math.max(0,DFS(root.right));
        ans = Math.max(ans,root.val+left+right);
        return root.val + Math.max(left,right);
    }
}
