class Solution {

    public int findFirst(int []nums, int target){
        int left=0;
        int right=nums.length;
        int midIndex;
        while(left<=right){
            midIndex=left+(right-left)/2;

            if(target<=nums[midIndex]){
                right=midIndex-1;
            }else{
                left=midIndex+1;
            }
        }
        return (left<nums.length && nums[left]==target)? left:-1;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findFirst(new int[]{1,2,2,3},2));
    }
}


