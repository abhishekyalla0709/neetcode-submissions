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
        int left = DFS(root.left);
        int right = DFS(root.right);
        ans = Math.max(ans,root.val+left+right);
        int path = Math.max(left,right);
        if(path<0){
            path=0;
        }
        int temp = root.val + path;
        if(temp<0){
            temp =0;
        }
        return temp;
    }
}
