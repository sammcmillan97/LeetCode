package Models;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { this.val = val; }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<Integer> GetLeafValueSequence(TreeNode head) {
        List<Integer> leaves = new ArrayList<Integer>();

        if (head == null) {
            return leaves;
        }

        if (head.left == null && head.right == null) {
            leaves.add(head.val);
            return leaves;
        }

        if (head.left == null) {
            leaves.addAll(GetLeafValueSequence(head.right));
            return leaves;
        }
        if (head.right == null) {
            leaves.addAll(GetLeafValueSequence(head.left));
            return leaves;
        }

        leaves.addAll(GetLeafValueSequence(head.left));
        leaves.addAll(GetLeafValueSequence(head.right));

        return leaves;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(3);
        
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(root.GetLeafValueSequence(root));

    }
 }