public class majorityElement_169 {
    //找到超过一半的数
    //可以使用投票算法，超过一半的数不能有两个
    //因为超过一半的数只会有一个，所以投票最后胜出的一定是大于一半数的那个数
    public int majorityElement(int[] nums) {
        int num=nums[0];
        int temp = 0;
        for(int c:nums){
            if(num==c){
                temp+=1;
            }else{
                temp-=1;
            }
            if(temp==0){
                num=c;
                temp=1;
            }
        }
        return temp;
    }
}
