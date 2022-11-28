import java.util.PriorityQueue;

public class getLeastNumbers_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> myQueue=new PriorityQueue<> (k);
        if(k==0) return new int[0];
        for(int n:arr){
            myQueue.add(n);
        }
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=myQueue.poll();
        }
        return result;
    }
}
