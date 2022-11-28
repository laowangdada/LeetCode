package dp;

public class climbStairs_70 {
    public int climbStairs(int n) {
        //f(n)=f(n-1)+f(n-2)
        int[] num=new int [n+1];
        num[0]=0;
        num[1]=1;
        for(int i=2;i<n+1;i++){
            num[i]=num[i-1]+num[i-2];
        }
        return num [n+1];
    }
}
