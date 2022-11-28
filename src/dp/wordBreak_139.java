package dp;


import java.util.HashSet;
import java.util.List;
/*
* 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
*
*
* 动态规划,前面可以，后面才能继续
* */
public class wordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet=new HashSet<>(wordDict);
        boolean []memo=new boolean [s.length()+1];
        memo[0]=true;
        //start表示不同长度字串s.substring(0,i)的起始坐标
        for(int i=1;i < s.length()+1;i++){
            for(int start=0;start<i;start++){
                if(memo[start]&&wordSet.contains(s.substring(start, i))){
                    memo[i]=true;
                }
            }

        }
        return memo[s.length()];
    }
}
