import Models.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
        
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null)  {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        //Must be the LCA
        if (leftTree != null && rightTree != null) {
            return root;
        }

        if (leftTree != null) {
            return leftTree;
        }
        if (rightTree != null) {
            return rightTree;
        }

        return null;
    }

}
