package dp;
import java.util.List;

public class minimumTotal_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        Integer[][] memo = new Integer[row][row];
        int col=0;
        //只能是下一行中相邻节点。所以下面一层的每个结点与上一层中相邻结点的最小和相加。

        return calculate(row,0,0,triangle, memo);

    }

    public int calculate(int allRow,int row,int col,List<List<Integer>> triangle,Integer[][]memo){
        if(row==allRow-1) {
            memo[row][col] = triangle.get(row).get(col);
           // return memo[row][col];
        }
        if(memo[row][col]!=null)
            return memo [row] [col];
        int left=calculate(allRow,row+1,col,triangle, memo);
        int right = calculate(allRow,row+1,col+1,triangle, memo);
        memo[row][col]=Math.min(left, right)+triangle.get(row).get(col);
        return memo[row][col];
    }
}
