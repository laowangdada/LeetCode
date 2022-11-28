import java.util.ArrayList;

public class KMP {

    //get Partial Match Table部分匹配表
    // PMT 中的值是字符串的前缀集合与后缀集合的交集中最长元素的长度。
    //next数组是PMT右部移动一位，next（0）置为-1
    public static int[] kmpNext(String dest){
        //先准备一个Next[]，默认字符串是不对称的
        int length = dest.length();
        int [] next=new int[length];
        next[0]=-1;//设置哨兵
        int j=0;//模式串的指针
        int t=-1;
        while(j<length-1){
            if(t<0||dest.charAt(j)==dest.charAt(t)){
                next[++j]=++t;
            }else{
                t=next[t];
            }
        }
        return next;
    }

    public static ArrayList<Integer> kmp(String str, String dest){
        int[] next=kmpNext(dest);
        ArrayList<Integer> result = new ArrayList<> ();
        int n=str.length();
        int m=dest.length();
        int i=0;
        int j=0;
        while(j<m+1 && i<n){
            //添加结果
            if(j==m){
                result.add(i-j);
                j=0;
            }
            if(j<0||str.charAt(i)==dest.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str="ABAABCAC";
        String dest="AB";
//        int []next=kmpNext(str);
//        System.out.println(Arrays.toString(next));
        System.out.println(kmp(str, dest));
    }



}
