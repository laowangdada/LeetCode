import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class findPeak_1901 {
    public static int[] findPeakGrid(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int start=0, end=row-1;
        int midRow=0;
        //以行为中心轴
        while(start<=end){
            midRow=start+(end-start)/2;

            //在mid行中找到最大值
            int midY=0;
            for (int i=0;i<col;i++){
                if(mat[midRow][i]>mat[midRow][midY]){
                    midY=i;
                }
            }
            if(getVal(midRow,midY,mat)>getVal(midRow,midY+1,mat) && getVal(midRow,midY,mat)>getVal(midRow,midY-1,mat) ){
                return new int[]{midRow,midY};
            }


            if(getVal(midRow,midY,mat)>getVal(midRow,midY+1,mat)){
                end=midRow;
                if(end==start) break;
            }else {
                start=midRow+1;
            }
        }

        return new int[]{start, end};
    }

    public static int getVal(int x, int y,int[][]mat){
        if(x<0|| x>=mat.length || y<0||y>=mat[0].length){
            return -1;
        }

        return mat[x][y];
    }

    public static void main(String[] args) {
        int[][] input=new int[][]{{7,2,3,1,2},{6,5,4,2,1}};
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        for(Integer i : list){
//            list.remove(i); //运行时抛出ConcurrentModificationException异常
//        }
//        System.out.println(list.size());

        List<String> strings=new ArrayList<>();

        strings.add("remove");
        strings.add("hello");
        Iterator<String> it = strings.iterator();
        while(it.hasNext()) {
            String str = it.next();
            if(str.equals("remove")){
                strings.remove(str);
            }
        }
        System.out.println(strings.size());
//        findPeakGrid(input);
    }
}
