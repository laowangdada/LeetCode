package stack;

public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int result=0,start=0,end=0;
        int length=arr.length;
        int max=0;
        int addLength=0;
        while (start < arr.length) {
            max=arr[start];
            while ((end<length && arr[end]>max) || max> addLength){
                end++;
                if(end<length)
                    max=Math.max(max,arr[end]);
                addLength+=1;
            }
            result++;
            start=end+1;
        }
        return result;
    }

    public static void main(String[] args){
      MaxChunksToSorted maxChunksToSorted=new MaxChunksToSorted();
      int a=maxChunksToSorted.maxChunksToSorted(new int[]{1,4,0,2,3,5});
      System.out.println(a);
    }
}