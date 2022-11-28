import Tree.TreeNode;

//①中序遍历,之后应该是一个递增顺序
//②递归，当前节点大于左孩子，小于右孩子
public class isValidBST_98 {
//    方法①
//    public boolean isValidBST(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        helpTree(root,list);
//        Integer cur=0;
//        Integer next=0;
//        System.out.println();
//        if(list.size()>1){
//            for(int i=0;i<list.size()-2;i++){
//                cur= list.get(i);
//                next=list.get(i+1);
//                if(cur>=next)
//                    return false;
//            }
//        }
//        return true;
//    }
//    public void helpTree(TreeNode cur, ArrayList<Integer> list){
//        if(cur == null)
//            return;
//        helpTree(cur.left,list);
//        list.add(cur.val);
//        helpTree(cur.right,list);
//    }




//    方法②
    public boolean isValidBST(TreeNode root){
        return helper(root,null,null);
    }
    public boolean helper(TreeNode cur,Integer lower,Integer higher){
        if(cur==null)
            return true;
        if(lower!=null&& cur.val<=lower)
            return false;
        if(higher!=null&& cur.val>=higher)
            return false;
        if(helper(cur.left,lower,cur.val)==false)
            return false;
        if(helper(cur.right,cur.val,higher)==false)
            return false;
        return true;
    }
}
