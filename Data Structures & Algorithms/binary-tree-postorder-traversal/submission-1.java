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
    public List<Integer> postorderTraversal(TreeNode root) {
        // List<Integer> list = new ArrayList<>();
        // postOrder(root, list);
        // return list;
        return postOrderIterative(root);
    }

    private void postOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    private List<Integer> postOrderIterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root==null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            TreeNode right = temp.right;
            TreeNode left = temp.left;
            if(left!=null){
                stack.push(left);
            }
            if(right!=null){
                stack.push(right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}