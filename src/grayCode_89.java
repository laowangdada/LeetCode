import java.util.ArrayList;
import java.util.List;

public class grayCode_89 {
    //超时
//    public List<Integer> grayCode(int n) {
//        //按位异或得到2的幂
//        List<Integer> result=new ArrayList<> ();
//        result.add(0);
//        HashSet<Integer> pool=new HashSet<> ();
//        int total= 1<<n;
//        for(int i=1;i < total; i++)
//            pool.add(i);
//        while(result.size()!=total){
//            Iterator<Integer> it = pool.iterator();
//            while(it.hasNext()){
//                int next=it.next();
//                if(isNext(result.get(result.size()-1),next)){
//                    result.add(next);
//                    it.remove();
//                }
//            }
//        }
//        return result;
//    }
//    public boolean isNext(int a,int b){
//        int c=a^b;
//        return c>0&&(c&(c-1))==0;
//    }


    /*镜像加一*/
    public List<Integer> grayCode(int n){
        List<Integer> result=new ArrayList<>();
        result.add(0);
        int head=1;
        for(int i=0;i<n;i++){
            for(int j=result.size()-1;j>=0;j--){
                result.add(head+result.get(j));
            }
            head<<=1;
        }
        return result;
    }
}
