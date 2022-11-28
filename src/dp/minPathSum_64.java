package dp;

public class minPathSum_64 {
    public int minPathSum(int [][] grid){
        int row=grid.length;
        int col=grid[0].length;
        Integer[][] memo=new Integer[row][col];
        return dpHelper(0,0,row-1,col-1,memo,grid);
    }
    public int dpHelper(int x,int y,int endx,int endy,Integer [] [] memo,int[][]grid){
        int right=Integer.MAX_VALUE ,down=Integer.MAX_VALUE;
        if(memo[x][y]!=null)
            return memo[x][y];
        if(x==endx && y == endy)
            return grid[x][y];
        if(x+1<=endx)
            right=dpHelper(x+1,y,endx,endy,memo,grid);
        if(y+1<=endy)
            down=dpHelper(x,y+1,endx,endy,memo,grid);
        memo[x][y]=Math.min(down,right)+grid[x][y];
        return memo [x][y];


    }
}
