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
    private boolean ans = false;  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        checkAllSubtree(root, subRoot);
        return ans;
    }

    private void checkAllSubtree(TreeNode root, TreeNode subRoot){
        if(root==null){
            return;
        }
        if(checkTree(root,subRoot)){
            ans = true;
        }
        checkAllSubtree(root.left,subRoot);
        checkAllSubtree(root.right,subRoot);
    }

    private boolean checkTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null && q!=null){
            return false;
        }
        if(p!=null && q==null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return checkTree(p.left,q.left) && checkTree(p.right,q.right);
    }


}
