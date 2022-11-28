import java.util.ArrayList;
import java.util.List;
public class solveNQueens_51 {
    public static void main(String[] args) {
        List<List<String>> results = new ArrayList<> ();
        results=solveNQueens(4);
        System.out.println(results);
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        solveNQueensHelper(n,0,new ArrayList<Integer>(),results);
        return results;
    }
    private static void solveNQueensHelper(int n,int row,List<Integer> colPlacements,List<List<String>> results){
        if(row==n)   //当访问到最后时候，生成结果添加到results
            results.add(generateResult(colPlacements,n));
        else{
            for(int col=0;col<n;col++){
                colPlacements.add(col);
                if(isValid(colPlacements)){
                    solveNQueensHelper(n,row+1,colPlacements,results);
                }
            //在一行里面找完一个位置之后要删掉去向下一个位置
            colPlacements.remove(colPlacements.size()-1);
            }
        }
    }
    //检测当前添加是否合理,不在同一行，不在同一列，不在对角线上（在对角线上时候，行距离=列距离）
    //colPlacements存放的是每一行Q在的列数
    private static boolean isValid(List<Integer> colPlacements){
        int rowCheck=colPlacements.size()-1;
        for(int curRow=0;curRow<rowCheck;curRow++){
            int absColDistance=Math.abs(colPlacements.get(curRow)-colPlacements.get(rowCheck));
            if(absColDistance==0||absColDistance==rowCheck-curRow)
                return false;
        }
        return true;
    }
    //使用List<Integer>生成对应字符串
    private static List<String> generateResult(List<Integer> colPlacements,int n) {
        List<String> result = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            StringBuilder temp = new StringBuilder();
            for (int col = 0; col < colPlacements.size(); col++) {
                if (col == colPlacements.get(row)) {
                    temp.append("Q");
                } else {
                    temp.append(".");
                }
            }
            result.add(temp.toString());
        }
        return result;
    }
}

