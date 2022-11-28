package dp;

public class uniquePaths_62 {
    //备忘录写法
    public int uniquePaths(int m, int n) {
        if(m==0&&n==0)
            return 0;
        if(m==0||n==0)
            return 1;
        Integer[][] memo=new Integer[m][n];
        dpHelper(0,0,m-1,n-1,memo);
        return memo [0][0];
    }
    public int dpHelper(int x,int y,int endx,int endy,Integer[][] memo){
        int right=0,down=0;
        if(memo[x][y]!=null)
            return memo[x][y];
        if(x==endx && y == endy)
            return 1;
        if(x+1<=endx)
            right=dpHelper(x+1,y,endx,endy,memo);
        if(y+1<=endy)
            down=dpHelper(x,y+1,endx,endy,memo);
        memo[x][y]=right+down;
        return memo [x][y];
    }
}
