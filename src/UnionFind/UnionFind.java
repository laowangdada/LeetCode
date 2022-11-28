package UnionFind;

import java.io.*;
import java.util.Scanner;

public class UnionFind implements UF{
    int [] unionMap;
    int [] treeSize;
    int unionCount=0;
    UnionFind(int size){
        this.unionMap =new int[size];
        this.treeSize=new int[size];
        for (int i = 0; i < size; i++) {
            this.unionMap[i]=i;
            this.treeSize[i]=1;
        }
        this.unionCount=size;
    }

    // 如果有N个结点,为什么树的高度不超过lgn.
    // 因为每次union都是小树合到大树上面,所以每次结点数量至少乘以2, 所以最多可以翻倍lgN次.

    @Override
    public void union(int p, int q) {
        if(!connected(p,q)){
            if(this.treeSize[p]<=this.treeSize[q]){
                this.unionMap[find(p)]=find(q);
                this.treeSize[find(q)]+=this.treeSize[find(p)];
            }else{
                this.unionMap[find(q)]=find(p);
                this.treeSize[find(p)]+=this.treeSize[find(q)];
            }
//            int target=this.unionMap[q];
//            for (int i = 0; i < this.unionMap.length; i++) {
//                if(this.unionMap[i]==target){
//                    this.unionMap[i]=this.unionMap[p];
//                }
//            }

            this.unionCount--;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public int find(int p) {
        while (unionMap[p]!=p) {
            // 路径压缩,每次查找根节点时候,如果没有指向根节点,则指向上层结点.
            unionMap[p]=unionMap[unionMap[p]];
            p=unionMap[p];
        }
        return p;
    }

    @Override
    public int count() {
        return this.unionCount;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\MSI-NB\\MYCODE\\IdeaProjects\\LeetCode\\src\\UnionFind\\UnionFindTestFIle.txt");
//        FileInputStream fi=new FileInputStream(file);
//        InputStreamReader reader = new InputStreamReader(fi);
        Scanner scanner=new Scanner(file);
        UnionFind unionFind=new UnionFind(scanner.nextInt());
        while (scanner.hasNextInt()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if(!unionFind.connected(p,q)){
                unionFind.union(p,q);
                System.out.println(p+" "+q);
            }
        }
    }

}
