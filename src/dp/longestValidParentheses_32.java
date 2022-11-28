package dp;

/*
*给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
示例 1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
* */

import java.util.Stack;

/*思路分析
* 括号的长度可以知道与之前的状态也是有关的，最长的括号一定是连续的。
* 备忘录来解决这个问题
* memo[i]表示以s[i]结尾的最长括号的长度
* 所以'（'结尾的都是0，因为一个有效括号不可能以'（'结尾
* */
public class longestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        int[] memo = new int [s.length()];
        int maxLength=0;
        Stack<Integer> memory = new Stack<> ();
        for(int i=0;i<s.length();i++){
            //左括号直接将下标放入栈中
            if(s.charAt(i)=='('){
                memory.push(i);
            }
            //右括号的话，如果栈不为空，直接pop。再计算在当前pop的左括号的前一个括号组成的括号长度是多少
            else if(!memory.isEmpty()){
                int lastLeft=memory.pop();
                int pre=lastLeft-1;
                int len=((lastLeft-1>=0)?memo[pre]:0)+i-lastLeft+1;
                memo[i]=len;
                maxLength= Math.max(maxLength, len);
            }
        }
        return maxLength;
    }
}
