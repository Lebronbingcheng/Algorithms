public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    TreeNode result = null;
    int sum = (-1) * Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int sumation = left + right + root.val;
        if (sumation > sum) {
            result = root;
            sum = sumation;
        }
        return sumation;
    }
}
