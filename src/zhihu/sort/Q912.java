package zhihu.sort;

public class Q912 {
    public int[] sortArray(int[] nums) {
        qSort(nums,0,nums.length-1);
        return nums;
    }
    public void qSort(int[]nums, int l, int r){
        if(l>=r) return;
        int left=l,right=r;
        int pivot=nums[l];
        while(left<right){
            while(left<right && nums[right]>=pivot){
                right--;
            }
            nums[left]=nums[right];
            while(left<right && nums[left]<pivot){
                left++;
            }
            nums[right]= nums[left];
        }
        nums[left]=pivot;
        qSort(nums,l,left-1);
        qSort(nums,left+1,r);
    }

    public void mergeSort(int[] nums,int start, int end){
        int mid = start + (end-start)/2;


    }
}
