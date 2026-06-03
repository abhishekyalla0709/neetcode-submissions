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
    private int count = 0;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    }

    private void inOrder(TreeNode root, int k){
        if(root==null){
            return;
        }
        inOrder(root.left,k);
        count++;
        if(k==count){
            ans = root.val;
        }
        if(count>k){
            return;
        }
        inOrder(root.right,k);
    }
}
