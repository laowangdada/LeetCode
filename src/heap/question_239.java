package heap;

import java.util.*;

//优先队列
public class question_239 {
    //    双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);//保存索引
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i>=k&&i-k==deque.getFirst())
                deque.pollFirst();
            //保证队列最左端永远是最大元素的索引
            //如果最近的元素比最后的元素还大，那么就把它剔除
            while (!deque.isEmpty() && nums[deque.getLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.add(i);
            if(i>=k-1)
                res.add(nums[deque.peekFirst()]);
        }
        int[] temp=new int[res.size()];
        int i=0;
        for (Integer n:res){
            temp[i]=n;
            i++;
        }
        return temp;
    }
}
//    public int[] maxSlidingWindow(int[] nums, int k) {
////        int[] results=new int[100];
//        if(nums.length==0 || k==0){
//            return new int[0];
//        }
//        ArrayList<Integer> results=new ArrayList();
//        PriorityQueue<myInt> maxHeap=new PriorityQueue<myInt>(k, new Comparator<myInt>() {
//            @Override
//            public int compare(myInt o1, myInt o2) {
//                return o2.getVal()-o1.getVal();
//            }
//        });
//        for(int i=0;i<nums.length;i++){
//            if(maxHeap.size()<k)
//                maxHeap.offer(new myInt(nums[i],i));
//            else{
//                maxHeap.remove(new myInt(0,i-k));
//                maxHeap.offer(new myInt(nums[i],i));
//                results.add(maxHeap.peek().getVal());
//            }
//
//        }
//        int[] temp=new int[results.size()];
//        int i=0;
//        for (Integer n:results){
//            temp[i]=n;
//            i++;
//        }
//        return temp;
//    }
class myInt{
    private int val;
    private int index;
    myInt(int val,int index){
        this.val=val;
        this.index=index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    @Override
    public boolean equals(Object obj){
        // 如果为同一对象的不同引用,则相同
        if (this == obj) {
            return true;
        }
        // 如果传入的对象为空,则返回false
        if (obj == null) {
            return false;
        }

        // 如果两者属于不同的类型,不能相等
        if (getClass() != obj.getClass()) {
            return false;
        }
        myInt other=(myInt) obj;
        return other.getIndex()==this.getIndex();
    }
}












