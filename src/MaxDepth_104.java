import Tree.TreeNode;
//思路，一个队列放结点和层数，广度优先遍历
//public class MaxDepth_104 {
//    public int maxDepth(TreeNode root) {
//        Queue<Pair<TreeNode,Integer>> queue=new ArrayDeque<>();
//        if(root==null) return 0;
//        int level=1;
//        queue.add(new Pair(root, level));
//        while(!queue.isEmpty()){
//            Pair<TreeNode, Integer> node = queue.poll();
//            TreeNode cur=node.getKey();
//            int curLevel=node.getValue();
//            if(cur!=null){
//                level=Math.max(level, curLevel);
//                queue.add(new Pair<> (cur.left, curLevel+1));
//                queue.add(new Pair<> (cur.right, curLevel+1));
//            }
//        }
//        return level;
//    }
//}

//深度优先遍历
public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        return dfs_helper(root);
    }
    public int dfs_helper(TreeNode cur){
        if(cur==null)
            return 0;
        return Math.max(dfs_helper(cur.left),dfs_helper(cur.right))+1;
    }
}
