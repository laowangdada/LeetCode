package zhihu.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        List<int[]> resList=new ArrayList();
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int[] last=intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur=intervals[i];
            if(cur[0]<=last[1]){
                last[1]=Math.max(last[1],cur[1]);
            }else {
                resList.add(last);
                last=cur;
            }
        }
        resList.add(last);
        return resList.toArray(new int[1][1]);
    }
}
