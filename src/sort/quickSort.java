package sort;
//快速排序，借助首位两个下标，i=0，j=len-1
//如果使用第一个作为base，则应该先从后找一个比base小的数，然后复制到第一个位置
//然后再从前开始找比base大的数，因为base现在的值已经是刚刚复制的比base小的数，所以肯定会后移
//在最后ij相等的时候，相当于停留的位置就是base应该放的位置。
public class quickSort {
    public static void quicKSort(int [] array){
        int len=0;
        if(array==null||array.length==0||array.length ==1)
            return;
        len=array.length;
        sort(array,0,len-1);
    }
    public static void sort(int[]array,int left,int right){
        if(right<=left)
            return;
        int base=array[left];
        int i=left;
        int j=right;
        while(i<j){
            while(i<j&&array [j]>=base){
                j--;
            }
            array[i]=array [j];
            while(i<j&&array [i]<=base){
                i++;
            }
            array [j] = array [i];
        }
       // array[left]=array[i];
        array [i] = base;
        sort(array, left,i-1);
        sort(array,i+1,right);
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,3,5,65,56,3,43,4,5,45,4,5,345,43};
        quicKSort(arr);
        for(int i:arr)
            System.out.print(i+" ");
    }

}
