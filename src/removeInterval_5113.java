import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class removeInterval_5113 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int row=intervals.length;
        int removeStart=toBeRemoved[0];
        int removeEnd = toBeRemoved[1];
        List<List<Integer> > result = new ArrayList<>();
        for(int i=0;i<row;i++){
            int a=intervals[i][0];
            int b=intervals[i][1];
            if(b<removeStart||a>removeEnd){
                result.add(new ArrayList<>(Arrays.asList(a,b)));
            }else if(a>=removeStart&&b<=removeEnd){

            }else{
                if(a<removeStart)
                    result.add(new ArrayList<>(Arrays.asList(a,removeStart)));
                if(b>removeEnd)
                    result.add(new ArrayList<>(Arrays.asList(removeEnd,b)));
            }
        }
        return result;
    }
}
