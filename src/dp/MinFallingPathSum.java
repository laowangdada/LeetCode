package dp;

public class MinFallingPathSum {
        int[][] dpMemo;

        int[][] direct={{1,-1},{1,0},{1,1}};
        public int minFallingPathSum(int[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;
            int result=Integer.MAX_VALUE;
            dpMemo=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++)
                    dpMemo[i][j]=Integer.MAX_VALUE;
            }

            for(int column=0; column<n;column++){
                dpMemo[m-1][column]= matrix[m-1][column];
            }

            for(int i=0;i<n;i++){
                result=Math.min(result,helper(0,i,matrix));
            }
            return result;
        }

        public int helper(int row, int col,int[][] matrix){
            if(row<0||row>=matrix.length||col<0||col>=matrix[0].length) {
                return Integer.MAX_VALUE;
            }
            if(dpMemo[row][col]<Integer.MAX_VALUE) return dpMemo[row][col];
            int curRes=Integer.MAX_VALUE;
            for(int i=0;i<3;i++){
                int nextRow=row+direct[i][0];
                int nextCol=col+direct[i][1];
                if(nextRow<0||nextRow>=matrix.length||nextCol<0||nextCol>=matrix[0].length) {
                    continue;
                }
                curRes=Math.min(curRes,helper(row+direct[i][0],col+direct[i][1],matrix));
            }
            dpMemo[row][col]=curRes+matrix[row][col];
            return dpMemo[row][col];
        }

    public static void main(String[] args) {
        MinFallingPathSum mf=new MinFallingPathSum();
        int [][] test={{17,82},{1,-44}};

        System.out.println(mf.minFallingPathSum(test));
    }
}
