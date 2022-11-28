import java.util.HashMap;

public class question_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numsMap=new HashMap<>();
        int i=0;
        int another=0;
        for(int n:nums){
            another=target-n;
            if(numsMap.containsKey(another)){
                return new int[]{i,numsMap.get(another)};
            }
            numsMap.put(n,i);
            i++;
        }
        throw new IllegalArgumentException("null");
    }
}
