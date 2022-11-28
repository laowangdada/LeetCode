import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class renren {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int sum=in.nextInt();
        int num=in.nextInt();
        ArrayList<Integer> price=new ArrayList<>();
        for(int i=0;i<num;i++){
            price.add(in.nextInt());
        }
        Collections.sort(price);
//商品价格表，商品数量，面值，当前价值
        int cursum=0;
        int d=dfs_helper(price,num-1,sum,cursum);
        if(d==(int) Double.POSITIVE_INFINITY){
            System.out.println(-1);;
        }else{
            System.out.println(d);
        }
    }
    public static int dfs_helper(ArrayList<Integer> price, int num,int sum,int cursum){
        if(num==-1){
            if(cursum<sum) return (int) Double.POSITIVE_INFINITY;
        }
        if(cursum>=sum){
            if(cursum>3*sum) return (int) Double.POSITIVE_INFINITY;
            else return cursum;
        }
        int k=dfs_helper(price, num-1, sum, cursum+price.get(num));
        int n=dfs_helper(price, num-1, sum, cursum+0);
        return Math.min(k,n);
    }
}
