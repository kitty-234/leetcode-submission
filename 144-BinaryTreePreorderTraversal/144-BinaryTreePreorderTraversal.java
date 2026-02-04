// Last updated: 2/4/2026, 12:57:37 PM
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        print(root,ans);
        return ans;
    }
    public void print(TreeNode root, List<Integer> ans){
        if (root==null) return;
        ans.add(root.val);
        print(root.left, ans);
        print(root.right, ans);
    }
}