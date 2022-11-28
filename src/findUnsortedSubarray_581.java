public class findUnsortedSubarray_581 {
    public int findUnsortedSubarray(int[] nums) {
        int start=0;
        int end=0;
        int len=nums.length;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;

        for(int i=0;i<len;i++){
            if(nums[i]>=max){
                max=nums[i];
            }else{
                end=i;
            }
            if(nums[len-1-i]<=min){
                min=nums[i];
            }else{
                start=len-1-i;
            }
        }
        System.out.println(start);
        System.out.println(end);
        return end-start+1;
    }
}
