import Tree.TreeNode;
//二叉树的最近公共祖先
public class lowestCommonAncestorTree_236 {//所有的递归的返回值有4种可能性，null、p、q、公共祖先
//    递归需要弄清楚
//    1》找整个递归的终止条件：递归应该在什么时候结束？
//    此题中，当找到q和p点时候是一个终止条件，另外就是空结点访问到叶子结点
//    2》找返回值：应该给上一级返回什么信息？
//    在每个结点，有三种情况，
//    一种是pq分布在左右子树，所以该节点就是最近公共祖先
//    另外两种是pq在左子树或者在右子树，所以公共祖先也是在左子树或者右子树上面
//    所以情况1，在左右子树，返回该节点
//    情况23，向上级返回，对应的孩子。
//    因为我们是从根节点root开始遍历，所以后面的信息都应该返回到root点，从第一层递归入口取到信息
//
//    3》本级递归应该做什么：在这一级递归中，应该完成什么任务？

    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q||root==null) {//先写递归截止条件：当找到p或者q的是时候就会返回pq
            return root;
        }
        TreeNode left = LowestCommonAncestor(root.left, p, q);//返回的结点进行保存，可能是null
        TreeNode right = LowestCommonAncestor(root.right, p, q);//也可能是pq，还可能是公共祖先
        if (left != null && right != null) {
            return root;//如果左右都存在，就说明pq出现在左右子树了，该结点就是公共祖先
        } else if (left != null) {//否则我们返回已经找到的那个值（存储在left，与right中），p或者q
            return left;//还有一种可能就是，由下面返回的公共祖先，并将这个值一路返回到最表层
        } else if (right != null) {
            return right;
        }
        return null;
    }
}