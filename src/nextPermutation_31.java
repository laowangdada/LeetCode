//下一个最大排列
//例子：1 3 2
//思路将下标 j 指向序列从后往前递增的的截至点（3）
//将后面递增序列中‘第一个比截至点j的前一位大的数字’和该点交换，（2-1）变成【2 3 1】
//再将j和后面的所有数字reverse【2 3 1】
//
public class nextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int j=nums.length-1;
        while (j>0&&nums[j]<=nums [j-1]){
            j--;
        }
        if(j>0){
            int i=nums.length -1;
            while(i>=0&&nums[i]<=nums[j-1])
                i--;
            swap(nums,i,j-1);
        }
        reverse(nums,j);
    }
    public void reverse(int[]nums,int start){
        int i=start,j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
