package Easy;
import Models.TreeNode;

public class SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        while(true) {
            if (root == null || root.val == val)
            {
                return root;
            } else if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
}
