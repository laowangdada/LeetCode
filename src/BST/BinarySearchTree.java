package BST;

public class BinarySearchTree {
    public BSTNode root;
    public BSTNode cur;
    public BinarySearchTree(){
        this.root=null;
    }
    public BSTNode searchReturnFather(BSTNode root,int val){
        if(root==null||root.data==val){
            return root;
        }
        this.cur=root;
        if(root.data>val)
            return searchReturnFather(root.left,val);
        else
            return searchReturnFather(root.right,val);
    }
    public void insert(int val){
        searchReturnFather(this.root,val);
        if(this.cur == null)
            this.root = new BSTNode(val,null,null);
        else{
            if(val>this.cur.data)
                this.cur.right = new BSTNode(val,null,null);
            else
                this.cur.left = new BSTNode(val,null,null);

        }
    }

    public static void main(String[] args) {

        BinarySearchTree BSTree = new BinarySearchTree();
        BSTree.insert(8);
        BSTree.insert(10);
        BSTree.insert(1);
        BSTree.insert(6);
        BSTree.insert(12);
        BSTree.insert(7);

       // System.out.println(BSTree.searchReturnFather(BSTree.root,100)==null);
    }
}
