import java.util.ArrayList;
import java.util.List;

//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
public class generateParenthesis_22 {

//    一般算法，要认识到，什么时候加左括号，什么时候加右括号。
//    只要有左括号就可以加左括号，右括号数量是在大于左括号数量时候才能加
//    整个递归的终止条件。
//    当左右括号用完时候，结束
//    一级递归需要做什么？
//    需要选择添加一个括号
//    应该返回给上一级的返回值是什么
//    void无需返回
//    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        Generate("",result,n,n);
//        return result;
//    }
//    public void Generate(String sublist,List<String> result,int left,int right){
//        if(left==0 &&right==0){
//            result.add(sublist);
//            return;
//        }
//        if(left>0){
//            Generate(sublist+"(", result, left-1, right);
////            System.out.println(sublist);
//        }
//        if(right>left){
//            Generate(sublist+")", result, left, right-1);
////            System.out.println(sublist);
//        }
//    }
//
//    public static void main(String[] args) {
//        generateParenthesis_22 a=new generateParenthesis_22();
//        System.out.println(a.generateParenthesis(3));
//    }

//更快捷的算法，直接对char数组进行赋值操作，省略了字符串的加减
    List<String> parenthesis = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        char[] string = new char[2*n];
        generate(0, n, n, string);
        return parenthesis;
    }

    public void generate(int index, int open, int close, char[] string) {
        if (open == 0 && close == 0) {
            parenthesis.add(new String(string));
            return;
        }

        if (open-1 >= 0 ) {
            string[index] = '(';
            generate(index+1, open-1, close, string);
        }

        if (close-1 >= open) {
            string[index] = ')';
            generate(index+1, open, close-1, string);
        }
    }
}
