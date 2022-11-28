import java.util.HashSet;

public class validateBinaryTreeNodes_5170 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        //不符合的情况，
        // 1，形成环，有一个节点是某个节点的孩子，又是另一个节点的孩子。或者相互指向
        //2,形成不止一颗二叉树，所有节点中，节点不是所有节点孩子数目大于1
        HashSet<Integer> temp=new HashSet<> ();
        for (int i =0; i < n; i++) {
            if(leftChild[i]!=-1){
                if(leftChild[leftChild[i]]==i||rightChild[leftChild[i]]==i)
                    return false;

                if(temp.contains(leftChild[i]))
                    return false;
                else
                    temp.add(leftChild[i]);
            }
            if(rightChild[i]!=-1){
                if(leftChild[rightChild[i]]==i||rightChild[rightChild[i]]==i)
                    return false;
                if(temp.contains(rightChild[i]))
                    return false;
                else
                    temp.add(rightChild[i]);
            }
        }
        if(temp.size()<n-1) return false;


        return true;

    }
}
