import Tree.TreeNode;

public class invertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        help(root);
        return root;
    }
    public void help(TreeNode root){
        if (root != null){
            swap(root.left,root.right);
            help(root.left);
            help(root.right);
        }
    }
    public void swap(TreeNode left,TreeNode right){
        TreeNode temp = right;
        right = left;
        left = temp;
    }

}
