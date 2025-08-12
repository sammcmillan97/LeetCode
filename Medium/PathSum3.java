import Models.TreeNode;

public class PathSum3 {

    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) return 0;
        return pathsFrom(root, targetSum) 
            + pathSum(root.left, targetSum) 
            + pathSum(root.right, targetSum);
    }

    private int pathsFrom(TreeNode node, long remaining) {
        if (node == null) return 0;
        remaining -= node.val;
        return (remaining == 0 ? 1 : 0)
            + pathsFrom(node.left, remaining)
            + pathsFrom(node.right, remaining);
    }
    
    
    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(2);                
        root.right.right.right = new TreeNode(3);


        PathSum3 s = new PathSum3();

        System.out.println(s.pathSum(root, 3));
    }

}

