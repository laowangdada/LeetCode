import java.util.*;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            if(i>0&&nums[i]==nums[i-1]) continue;  //去重
            int left=i+1,right=nums.length-1;
            while(left<right){
                if(nums[i]+nums [left]+nums [right]==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while(left<right&&nums[left]==nums[left+1])
                        left++;
                    while(left<right&&nums[right]==nums[right-1])
                        right--;
                    left++;
                    right--;
                    continue;
                }
                if(nums[i]+nums [left] + nums [right]>0)
                    right--;
                if(nums [i] + nums [left] + nums [right]<0)
                    left++;
            }
        }
        return result;
    }
}
