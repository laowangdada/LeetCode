package DivideAndConquer;
//输入要注意int越界，所以改用long来存
public class myPow {
    public double myPow(double x, int n) {
        long N=n;
        return helpEven(x,N);
    }
    public double helpEven(double x, long n){
        if(n==1)
            return x;
        if(n==0)
            return 1;
        if(n<0)
            return 1/helpEven(x,-n);
        if(n%2==0)
            return helpEven(x*x,n/2);
        else
            return x*helpEven(x,n-1);
    }

    public static void main(String[] args) {
        myPow my=new myPow();

        System.out.println(my.myPow(2,-10));
    }
//    这种解法的错误性，分治法降低复杂度。而下面解法中最后调用helpEven(x,n/2)*helpEven(x,n/2);相当于暴力递归。
//    一万个x相乘=5000个x^2相乘
//    而不是一万个x相乘=5000个x相乘再乘以5000个x，相当于又重复计算了5000个x相乘，并没有化简，要注意分治之后的子问题究竟是什么样的。
//    public double myPow(double x, int n) {
//        int flag=1;//记录n的正负，1为正，0为负
//        int N=n>0?n:-n;//把n记录成正数
//        if(n<0){
//            flag=0;
//        }
//        double result =0;
//        result =helpEven(x,N);
//        if(flag ==0){
//            return 1/result;
//        }else
//            return result;
//    }
//    public double helpEven(double x, int n){
//        if(n==1)
//            return x;
//        if(n==0)
//            return 1;
//        if(n%2==0)
//            return helpEven(x,n/2)*helpEven(x,n/2);
//        else
//            return x*helpEven(x,n/2)*helpEven(x,n/2);
//    }
}
