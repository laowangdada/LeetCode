package zhihu.sort;

import java.util.Arrays;
import java.util.Comparator;

public class Q179 {
    public String largestNumber(int[] nums) {
        String[] strNum = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strNum[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(strNum,getCp());
        StringBuilder sb=new StringBuilder();
        for(String a:strNum){
            sb.append(a);
        }
        return sb.toString();
    }

    public Comparator<String> getCp(){
        return (str1,str2)->{
            String sumA=str1+str2;
            String sumB=str2+str1;
            return sumB.compareTo(sumA);
        };
    }

    public static void main(String[] args) {
        new Q179().largestNumber(new int[]{3,30,34,5,9});
    }
}
