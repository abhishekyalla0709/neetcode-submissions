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
    private int prev = Integer.MIN_VALUE;
    private boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode root){
        if(root==null || ans==false){
            return;
        }
        inOrder(root.left);
        if(root.val<=prev){
            ans = false;
        }
        prev=root.val;
        inOrder(root.right);
    }

    // left node right -> inOrder traversal
}
