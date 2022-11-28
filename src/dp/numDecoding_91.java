package dp;

public class numDecoding_91 {
    //s(1,n)=s(1,n-1)+s(1,n-2)
    //为了方便计算，设置哨兵memo[0] memo[x]表示x长的子串有多少种解码方式
    public static int numDecodings(String s){
        if(s.charAt(0)=='0')
            return 0;
        int []memo=new int[s.length()+1];
        memo[1]=memo[0]=1;
        for(int length=2;length<s.length()+1;length++){
            //如果当前字符不是'0'，memo[length]包含前第一位数字的组合总数。并且，可能包含前第二位的和
            if(s.charAt(length-1)!='0'){
                memo[length]=memo[length-1];
                if(s.charAt(length-2)=='1'||(s.charAt(length-2)=='2'&&s.charAt(length-1)<'7'))
                    memo[length]=memo[length]+memo[length-2];
            }else{
                // 如果是0，memo[length]只可能包含前第二个数字的解码和，因为当前的0必须要和前一位组成一个数字.如果前一位数字大于2或者等于0可以提前结束，不用循环到底部
                if(s.charAt(length -2)>'2'||s.charAt(length-2)=='0')
                    return 0;
                else
                    memo[length]=memo[length]+memo[length-2];
            }
        }
        return memo[s.length()];
    }

}
