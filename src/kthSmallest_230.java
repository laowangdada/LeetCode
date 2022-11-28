import Tree.TreeNode;
public class kthSmallest_230 {
    int count;
    public int kthSmallest(TreeNode root,int k){
        count =k;
        return helper(root);
    }
    public Integer helper(TreeNode root){
        Integer left=null;
        Integer right=null;
        if(root==null)
            return null;
        left=helper(root.left);
        count--;
        if(count==0)
            return root.val;
        right=helper(root.right);
        if(left!=null)
            return left;
        else
            return right;
    }
}
