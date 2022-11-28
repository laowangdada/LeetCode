package Tree;

import java.util.*;

class RemoveEmpty {
    List<TreeNode> result=new ArrayList();
    public List<TreeNode> generateTrees(int n) {
        int[] availNums =new int[n+1];
        backTrack(null,null,0,availNums,n);

        Map<Integer,Integer> map=new HashMap<>();

        StringBuilder sb=new StringBuilder();
        StringBuilder s=new StringBuilder();
        sb.append(s);
        return result;
    }

    public int closeLampInTree(TreeNode root) {
        int action=0;
        return action;
    }
    public void backTrack(TreeNode cur,TreeNode root, int curSize,int[] availNums,int n){
        if(curSize == n){
            result.add(root);
            return;
        }

        for(int i=1;i<=n;i++){
            if(availNums[i]==0){
                availNums[i]=1;
                TreeNode temp=new TreeNode(i);
                if(curSize==0){
                    root =temp;
                    cur=root;
                }else{
                    if(i<cur.val){
                        cur.left=temp;

                        backTrack(cur.left,root,curSize+1,availNums,n);
                        cur.left=null;
                    }else{
                        cur.right=temp;
                        backTrack(cur.right,root,curSize+1,availNums,n);
                        cur.right=null;
                    }
                }

                availNums[i]=0;
//                curSize--;
            }
        }
    }

    public static void main(String[] args) {
        RemoveEmpty removeEmpty=new RemoveEmpty();
        removeEmpty.generateTrees(3);
    }
}