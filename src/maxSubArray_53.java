public class maxSubArray_53 {
    public int maxSubArray(int[] nums){
        double curMax=Double.NEGATIVE_INFINITY;
        int temp=-1;
        for(int i:nums){
            if(temp<0){
                 temp=i;
            }else{
                temp=temp+i;
            }
            if(temp>curMax)
                curMax=temp;
        }
        return (int)curMax;
    }
}
