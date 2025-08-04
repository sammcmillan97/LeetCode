package Easy;
import Models.TreeNode;
import java.util.List;

class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafOne = root1.GetLeafValueSequence(root1);
        List<Integer> leafTwo = root2.GetLeafValueSequence(root2);

        return leafOne.equals(leafTwo);
    }


    public static void main(String[] args) {
        LeafSimilarTrees s = new LeafSimilarTrees();

        TreeNode rootOne = new TreeNode(1);
        rootOne.left = new TreeNode(2);
        rootOne.right = new TreeNode(200);
        
        TreeNode rootTwo = new TreeNode(1);
        rootTwo.left = new TreeNode(2);
        rootTwo.right = new TreeNode(200); 

        System.out.println(s.leafSimilar(rootOne, rootTwo));
    }
}