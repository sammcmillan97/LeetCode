import java.util.ArrayList;
import java.util.List;

import Models.TreeNode;

public class CountGoodNodesInBinaryTree {



    public int goodNodes(TreeNode root) {
        List<Integer> goodNodes = new ArrayList<Integer>();
        int benchMark = root.val;

        getGoodNodes(root, benchMark, goodNodes);

        return goodNodes.size();
    }

    public void getGoodNodes(TreeNode node, int benchMark, List<Integer> goodNodes) {

        if (node == null) {
            return;
        }

        if (node.val >= benchMark) {
            goodNodes.add(node.val);
            benchMark = node.val;
        }

        getGoodNodes(node.left, benchMark, goodNodes);
        getGoodNodes(node.right, benchMark, goodNodes);
        return;
    }
}


