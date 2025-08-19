import Models.TreeNode;

public class LongestZigZagPathInABinaryTree {

    private int max = 0;

    public int longestZigZag(TreeNode root) {
        
        dfs(root);
        return max;
        
    }


    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{-1, -1};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int zigLeft = 1 + left[0];
        int zigRight = 1 + right[1];

        max = Math.max(max, Math.max(zigLeft, zigRight));

        return new int[]{zigRight, zigLeft};
    }


}
