public class maximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int row=matrix.length;
        int col=matrix [0].length;
        int[][] len=new int [row] [col];
        int max=0;
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++){
//                if(matrix [i] [j]=='1'&&i-1>=0&&j-1>=0){
//                    //方法过于复杂，可以利用左边和上边来确定
//                    int lastLen=len[i-1][j-1];
//                    int m=1;
//                    for(int k=1;k<=lastLen;k++){
//                        if(matrix[i][j-k]=='1'&&matrix[i-k][j]=='1')
//                            m++;
//                        else
//                            break;
//                    }
//                    len[i][j]=m;
//                    if(len[i][j]>max)
//                        max=len[i][j];
//                }
//                else if(matrix[i][j]=='1'){
//                    len[i][j]=1;
//                    if(max==0)
//                        max=1;
//                }
//                System.out.println(len[i][j]);
//            }
//        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix [i] [j]=='1'&&i-1>=0&&j-1>=0){
                    //方法过于复杂，可以利用左边、上边和斜对角来确定
                    int oblique=len[i-1][j-1];//斜对角
                    int leftAndRight= Math.min(len[i-1][j],len[i][j-1]);//左边和右边
                    len[i][j]=Math.min(oblique,leftAndRight)+1;
                    if(len[i][j]>max)
                        max=len[i][j];
                }
                else if(matrix[i][j]=='1'){
                    len[i][j]=1;
                    if(max==0)
                        max=1;
                }
            }
        }
        return max*max;
    }
}
