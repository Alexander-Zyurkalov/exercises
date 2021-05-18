package json.another_dependent_package;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) { this.val = value; }
}




public class BinaryTreeLCA {
    public static TreeNode convertToTreeNode(String[] atrArr) {
        int i = 0;

        TreeNode treeNode = new TreeNode( Integer.parseInt(atrArr[i]) );


        return treeNode;
    }
    public static String BinaryTreeLCA(String[] strArr) {
        // code goes here
        String tree = strArr[0];
        int num1 = Integer.parseInt(strArr[1]);
        int num2 = Integer.parseInt(strArr[2]);


        return strArr[0];
    }
}
