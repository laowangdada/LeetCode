package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Permute_46 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ArrayDeque<Integer> path=new ArrayDeque<>();

        String s="aa";
//        Integer.
//        ArrayList
        return permuteHelper(nums,path);
    }

    public List<List<Integer>> permuteHelper(int[] choise,ArrayDeque<Integer> path){
        if(path.size()==choise.length) {
            this.result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < choise.length; i++) {
            if (path.contains(choise[i]))
                continue;
            path.add(choise[i]);
            permuteHelper(choise, path);
            path.removeLast();
        }
        return result;
    }
}
