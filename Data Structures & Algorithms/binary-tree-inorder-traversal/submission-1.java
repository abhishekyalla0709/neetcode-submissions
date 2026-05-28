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
    public List<Integer> inorderTraversal(TreeNode root) {
        //List<Integer> list = new ArrayList<>();
        //inOrder(root, list);
        //return list;
        return inOrderIterative(root);
    }

    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    private List<Integer> inOrderIterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode r = root;
        while(true){
            if(r!=null){
                stack.push(r);
                r=r.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                r = stack.pop();
                list.add(r.val);
                r = r.right;
            }
        }
        return list;
    }
}