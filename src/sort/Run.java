package sort;

public class Run {
    public static void main(String[] args) {
        int[] data={5,6,4,9,6,8,10,1,2,3};
        quickSort(data);
        for(int i:data)
            System.out.print(i+"-");
    }
    public static void quickSort(int[] arr){
        if(arr.length==0)
            return;
        int len=arr.length;
        sort(arr,0,len-1);
    }
    public static void sort(int[] array,int left,int right){
        if(right<=left) return;
        int base=array[left];
        int i=left,j=right;
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
        array [i] = base;
        sort(array, left,i-1);
        sort(array,i+1,right);
    }
}
