public class maximalRectangle_85 {
    //暴力解法
//    public int maximalRectangle(char[][] matrix){
//        int maxArea=0;
//        int row=matrix.length;
//        if(row==0) return 0;
//        int col=matrix[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j <col;j++ ){
//                int tempWidth=0;
//                int tempArea=0;
//                int minTempLength=Integer.MAX_VALUE;
//                int tempI=i;
//                int tempJ=j;
//                while(tempI<row&&matrix[tempI][tempJ]=='1'){
//                    tempWidth++;
//                    int tempLength=0;
//                    while(tempJ<col&&matrix[tempI][tempJ]=='1'){
//                        tempLength++;
//                        tempJ++;
//                    }
//                    minTempLength=Math.min(tempLength,minTempLength);
//                    tempArea=Math.max(tempArea,minTempLength*tempWidth);
//                    tempI++;
//                    tempJ=j;
//                }
//             maxArea=Math.max(tempArea,maxArea);
//            }
//        }
//        return maxArea;
//    }

    public int maximalRectangle(char[][] matrix){
        int maxArea =0;

        return maxArea;
    }
}
