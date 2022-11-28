import Tree.TreeNode;

import java.util.*;

public class levelOrder_102 {
//    广度优先搜索
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        List<List<Integer>> result=new ArrayList<> ();
//        if(root==null) return result;
//        Queue<TreeNode> queue=new ArrayDeque<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            int levelSize=queue.size();
//            List<Integer> level=new ArrayList<>();//存放当前层的结果
//            level.clear();
//            for(int i=0;i<levelSize;i++){
//                TreeNode cur=queue.poll();
//                level.add(cur.val);
//                if(cur.left!=null){
//                    queue.add(cur.left);
//                }
//                if(cur.right!=null){
//                    queue.add(cur.right);
//                }
//            }
//            result.add(level);
//        }
//        return result;
//    }


    //深度优先搜索
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        dfsHelper(root,0,result);
        return result;
    }
    public void dfsHelper(TreeNode node,int level,List<List<Integer>> result){
        if(node==null) return;
        List<Integer> levelList=new ArrayList<> ();
        //到了一层之后加上对应层的list
        if(result.size()<level+1){
            result.add(levelList);
        }
        result.get(level).add(node.val);
        dfsHelper(node.left,++level,result);
        dfsHelper(node.right,++level,result);
    }
}
