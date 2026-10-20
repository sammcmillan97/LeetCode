package BinaryTree.Easy;

import Models.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricR(root.left, root.right);
    }

    public boolean isSymmetricR(TreeNode left, TreeNode right) {
        if (left == null & right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && isSymmetricR(left.left, right.right) && isSymmetricR(left.right, right.left);
    }

}
