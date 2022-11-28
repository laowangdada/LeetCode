package dp;

public class jump_45 {
    public static int jump(int[] nums) {
        int farestCanGo=0;//当前能走的最远距离
        int best=0;//最佳的下一步位置
        int nextFarest=0;//下一步能走的最远距离
        int minStep=0;
        for(int index=0;index<nums.length;){
            farestCanGo=index+nums[index];
            nextFarest=0;
            if(farestCanGo>=nums.length-1){
                return ++minStep;
            }
            //从当前位置的下一步开始遍历
            for(int j=index+1;j<=farestCanGo&&j<nums.length;j++){
                if(j+nums [j]>nextFarest){
                    best=j;
                    nextFarest=j+nums [j];
                }
            }
            index=best;
            minStep++;
        }
        return minStep;
    }

    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        int a=jump(nums);
        System.out.println(a);
    }
}
