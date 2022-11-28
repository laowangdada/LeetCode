import Tree.TreeNode;

import	java.awt.TextField;//二叉搜索树最近的公共祖先
//从根节点开始遍历树
//如果节点 pp 和节点 qq 都在右子树上，那么以右孩子为根节点继续 1 的操作
//如果节点 pp 和节点 qq 都在左子树上，那么以左孩子为根节点继续 1 的操作
//如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 pp 和节点 qq 的 LCA 了
public class lowestCommonAncestorBST_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp;
        //交换使得p值小于等于q的值
        if(p.val>q.val){
            temp=p;
            p=q;
            q=temp;
        }
        while(root != null){
            if(p.val<=root.val&&q.val>=root.val)
                return root;
            else if (p.val>root.val&&q.val>root.val)
                root=root.right;
            else
                root = root.left;
        }
        throw new RuntimeException();
    }
}
