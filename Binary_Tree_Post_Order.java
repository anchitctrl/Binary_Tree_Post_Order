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
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while(!stack.isEmpty() || temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            else{
                TreeNode current=stack.peek().right;
                if(current==null){
                    current=stack.pop();
                    list.add(current.val);
                    while(!stack.isEmpty() && current == stack.peek().right) {
		                	current = stack.pop();
		                	list.add(current.val);
                    }
                
                }
                else{
                    temp=current;
                }
            }
        }
        return list;
        
    }
}
