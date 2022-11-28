public class maxProduct_152 {
    public int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;

        int preMax=nums[0];
        int preMin=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            int curMax=Math.max(Math.max(preMax*nums[i],preMin*nums[i]),nums[i]);
            int curMin=Math.min(Math.min(preMax*nums[i],preMin*nums[i]),nums[i]);
            result=Math.max(result,curMax);
            preMax=curMax;
            preMin=curMin;
        }

        return result;
    }
}
