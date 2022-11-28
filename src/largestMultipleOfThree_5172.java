public class largestMultipleOfThree_5172 {
    public String largestMultipleOfThree(int[] digits) {
        //数字和是3的倍数即可
        int[] map=new int[10];
        int sum=0;
        for(int n:digits){
            map[n]++;
            sum+=n;
        }
        if(sum==0) return "0";
        int rem=sum%3;
        switch (rem){
            case 0:
                break;
            case 1:
                if(del(1,map)) break;
                del(2,map);
                if(del(2,map)) break;
            case 2:
                if(del(2,map)) break;
                del(1,map);
                if(del(1, map)) break;
            default :
                return "";
        }
        StringBuilder res =new StringBuilder();
        for(int i=9;i>=0;i--){
            int num=map[i];
            while(num>0) {
                res.append(String.valueOf(i));
                num--;
            }
        }
        return res.toString();
    }
    public boolean del(int n,int[]map){
        for(int i=n;i<10;i+=3){
            if(map[i]>0){
               map[i]--;
               return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        largestMultipleOfThree_5172 temp=new largestMultipleOfThree_5172();
        System.out.println(temp.largestMultipleOfThree(new int[]{8,6,7,1,0}));
    }
}
