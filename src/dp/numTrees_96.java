package dp;


/*给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？*/
//memo[n]=n个节点的二叉排序树的个数
//令f(x)=以x为根的二叉搜索树的个数=memo[x-1]*memo[n-x]
//memo[n]=f(1)+f(2)+....+f(n)=memo[0]*memo[n-1]+...+memo[n-2]*memo[1]+memo[n-1]*memo[0];
public class numTrees_96 {
    public int numTrees(int n){
        int[] memo=new int[n+1];
        memo[0]=1;
        memo[1]=1;
        for(int i=2;i<=n;i++){  //从2个结点的二叉排序树数量开始计算到n个结点二叉排序树数量
            for(int j=1;j<=i;j++){//对于i个结点而言，每个j为根节点数量
                memo[i]=memo[i]+memo[j-1]*memo[i-j];
            }
        }
        return memo [n];
    }
}
