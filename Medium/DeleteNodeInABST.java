
//Runtime: beats 100.00%
//Memory: beats 14.44%

import Models.TreeNode;

public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        TreeNode rootCopy = root;
        TreeNode parent = null;

        //Search for node to remove 
        if (root.val != key) {
            while(true) {
                if (root == null || root.val == key)
                {
                    break;
                } else if (root.val < key) {
                    parent = root;
                    root = root.right;
                } else {
                    parent = root;
                    root = root.left;
                }
            }
            //If node does not exist return
            if (root == null) {
                return rootCopy;
            }

            boolean isLeftChild = (parent.val > root.val);

            //check if node has no children, simply replace root with null 
            if (root.right == null && root.left == null) {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            //Check if right child is null update parent to point to root.left in place of root    
            } else if (root.right == null) {
                if (isLeftChild) {
                    parent.left = root.left;
                } else {
                    parent.right = root.left;
                }
            //If both child are presentwe must append left child to most left node on right subtree 
            } else {    
                TreeNode leftMostNode = returnLeftMostNode(root.right);
                leftMostNode.left = root.left;
                if (isLeftChild) {
                    parent.left = root.right;
                } else {
                    parent.right = root.right;
                }
            }
            return rootCopy;
        //If the root node is the head of the tree we dont need to consider the parent
        } else {
            if (root.right == null && root.left == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                TreeNode leftMostNode = returnLeftMostNode(root.right);
                leftMostNode.left = root.left;
                return root.right;
            }   
        }
    }

    public TreeNode returnLeftMostNode(TreeNode root) {
        while(true) {
            if (root.left == null) {
                break;
            } else {
                root = root.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
