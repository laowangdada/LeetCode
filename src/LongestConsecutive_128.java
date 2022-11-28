import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive_128 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length, max = 1;
        Set<Integer> set = new HashSet<>();
        for (int v : nums) set.add(v);

        for (int v : nums) {
            if (set.contains(v - 1)) continue;
            int r = v; // r: right 表示「以 v 开头，能连续到多少」
            while (set.contains(r + 1)) r++; // 逐个查看
            max = Math.max(max, r - v + 1); // 记录区间 [v, r] 长度
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums={100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}