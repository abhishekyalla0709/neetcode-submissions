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
    private boolean ans = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        sameTree(p,q);
        return ans;
    }

    private void sameTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return;
        }
        if(p==null && q!=null){
            ans = false;
            return;
        }
        if(p!=null && q==null){
            ans = false;
            return;
        }
        if(p.val!=q.val){
            ans = false;
            return;
        }
        sameTree(p.left,q.left);
        sameTree(p.right,q.right);
    }
}
