import Models.TreeNode;
import java.util.List;
import java.util.ArrayList;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        
        List<Integer> sums = new ArrayList<>();
        getSumOfEachLevel(root, sums, 1);
        int maxSum = sums.get(0);
        int maxLevel = 1;

        for(int sum : sums) {
            System.out.println(sum);
        }
        
        for(int i = 0; i < sums.size(); i++) {
            if (sums.get(i) > maxSum) {
                maxSum = sums.get(i);
                maxLevel = i + 1;
            }
        }

        return maxLevel;

    }

    public void getSumOfEachLevel(TreeNode root, List<Integer> sums, int depth) {

        if (root == null) {
            return;
        }

        if (depth > sums.size()) {
            sums.add(root.val);
        } else {
            sums.set(depth - 1, sums.get(depth - 1) + root.val);
        }

        getSumOfEachLevel(root.right, sums, depth + 1);
        getSumOfEachLevel(root.left, sums, depth + 1);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(-100);
        root.left = new TreeNode(-200);
        root.right = new TreeNode(-300);
        root.left.left = new TreeNode(-20);                
        root.left.right = new TreeNode(-5);
        root.right.left = new TreeNode(-10);
        MaximumLevelSumOfABinaryTree s = new MaximumLevelSumOfABinaryTree();
        System.out.println(s.maxLevelSum(root));
    }
}
