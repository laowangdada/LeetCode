package dp;

public class canJump_55 {
    //动态规划备忘录
    /**
    public boolean canJump(int[] nums) {
        Boolean [] memo=new Boolean [nums.length];
        for(int i=0;i<nums.length; i++)
            memo[i]=null;
        return dpHelper(0,nums.length-1,nums,memo);

    }
    public boolean dpHelper(int start,int end,int[] nums,Boolean [] memo) {
        if(memo[start]!=null)
            return memo [start];
        if(start==end)
            return true;
        int step=nums[start];
        if(step==0)
            return false;
        boolean cur=false;
        for(int i=step;i>0; i--){
            if(start+i>=end)
                cur=true;
            else
                cur=dpHelper(start+i, end, nums, memo);
            if(cur==true)
                break;
        }
        memo[start]=cur;
        return cur;
    }
     **/
    //贪心算法
    public boolean canJump(int []nums){
        //思路，从起始点开始跳，记录最远能跳的距离。
        // 记作farestCanGo，遍历数组，在每个位置index处，计算最远能走的距离。如果遍历的i已经跑到farestCanGo前面了，那就是不可达的。

        int farestCanGo=0;
        for(int index=0;index<nums.length; index++){
            if(index>farestCanGo)
                return false;
            farestCanGo=Math.max(farestCanGo,index+nums[index]);
            if(farestCanGo>=nums.length-1)
                return true;
        }
        return true;
    }
}
