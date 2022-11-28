import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum_39 {
    public static void main(String[] args) {
        int []a={2,3,6,7};
        int target=7;
        List<List<Integer>> results=combinationSum(a,target);
        System.out.println(results);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> re=new ArrayList<>();
        combinationSumHelper(0,target, candidates,re, results);
        return results;
    }
    public static void combinationSumHelper(int curSum,int target,int[] candidates,
                                            List<Integer> re,
                                            List<List<Integer>> results){
        if(curSum==target)
        {
            results.add(new ArrayList<> (re));
            //results.add(re);
        }
        else{
            for(int i=0;i<candidates.length; i++){
                int temp=candidates[i];

                if(re.isEmpty()||temp>=re.get(re.size()-1)){
                    re.add(temp);
                    if(curSum+temp<=target){
                        combinationSumHelper(curSum+temp, target,candidates,re,results);
                    }
                    re.remove(re.size()-1);
                }

            }
        }
    }
}
