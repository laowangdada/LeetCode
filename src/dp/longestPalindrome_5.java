package dp;

public class longestPalindrome_5 {

    //dp思路分析
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<=1)
            return s;
        int maxLength=1;
        //substring左闭右开
        String longestStr=s.substring(0,1);
        boolean [][]dp=new boolean[len][len];
        for(int right=1;right<len;right++){
            for(int left=0;left<right; left++){
                if(s.charAt(left) ==s.charAt(right)&&(right-left<=2||dp[left+1][right-1])){
                    dp[left][right]=true;
                    if(maxLength<right-left+1){
                        maxLength=right - left +1;
                        longestStr=s.substring(left, right+1);
                    }
                }
            }
        }
        return longestStr;
    }
}
