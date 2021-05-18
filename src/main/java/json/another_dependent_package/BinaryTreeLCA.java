package json.another_dependent_package;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) { this.value = value; }
}



public class BinaryTreeLCA {
    public static TreeNode convertToTreeNode(TreeNode root, List<Integer> treeNums, int num1, int num2) {
        int i = 0;
        root.left = new TreeNode(treeNums.remove(1));
        root.right = new TreeNode(treeNums.remove(2));

        return root;
    }
    public static String BinaryTreeLCA(String[] strArr) {
        // code goes here
        String tree = strArr[0];
        int num1 = Integer.parseInt(strArr[1]);
        int num2 = Integer.parseInt(strArr[2]);

        List<Integer> treeNums = Arrays.stream(tree.split(", *")).map(Integer::parseInt).collect(Collectors.toList());
        TreeNode treeNode = convertToTreeNode(new TreeNode(treeNums.remove(0)), treeNums, num1, num2);

        return strArr[0];
    }
}
