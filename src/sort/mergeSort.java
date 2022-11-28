package sort;

import java.util.Arrays;

public class mergeSort {

    public static int[] mymergeSort(int []arr,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            mymergeSort(arr,start, mid);
            mymergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
        return arr;
    }
    public static void merge(int []arr,int left,int mid,int right){
        int i=left,j=mid+1;
        int k=0;
        int[] temp=new int[right-left+1];
        int length=temp.length;
        while (i<=mid&&j<=right){
            if(arr[i]<=arr [j])
                temp[k++]=arr [i++];
            else
                temp[k++]=arr[j++];
        }
        while(i<=mid)
            temp [k++] = arr [i++];
        while (j<=right)
            temp [k++] = arr [j++];
        //只是在当前分治的位置，改变数的位置
        // merge就是分，分完之后合，在另外的数组合，合好了之后复制会原数组即可

        for(int t=0;t<length;t++)
            arr [left++] = temp [t];
    }

    public static void main(String[] args) {
        int[]a={49, 38, 65, 97, 76, 13, 27, 50};
        a=mergeSort.mymergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
