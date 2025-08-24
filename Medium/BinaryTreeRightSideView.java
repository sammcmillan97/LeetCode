import java.util.List;
import java.util.Queue;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;

import Models.TreeNode;

public class BinaryTreeRightSideView {
        public List<Integer> rightSideView(TreeNode root) {
            Integer depth = 0;
            List<Integer> returnList = new ArrayList<>();
            if (root == null) {
                return returnList;
            }
            Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = new LinkedList<>();
            queue.add(new AbstractMap.SimpleEntry<>(root, 1));
                
            while(queue.size() != 0) {
                AbstractMap.SimpleEntry<TreeNode, Integer> entry = queue.remove();
                if (entry.getValue() > depth) {
                    depth++;
                    returnList.add(entry.getKey().val);
                }
                if (entry.getKey().right != null) {
                    queue.add(new AbstractMap.SimpleEntry<>(entry.getKey().right, entry.getValue() + 1));
                }
                if (entry.getKey().left != null) {
                    queue.add(new AbstractMap.SimpleEntry<>(entry.getKey().left, entry.getValue() + 1));
                }
            }
            return returnList;
        }
}


