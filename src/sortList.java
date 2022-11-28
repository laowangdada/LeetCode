import List.ListNode;

import java.util.*;

//优先队列
//public class sortList {
//    public static ListNode sortList(ListNode head){
//        Queue<ListNode> queue = new PriorityQueue<ListNode> (new Comparator<ListNode> (){
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val-o2.val;
//            }
//        });
//        while(head!=null){
//            ListNode temp=head.next;
//            head.next=null;
//            queue.add(head);
//            head = temp;
//        }
//        head=null;
//        ListNode root=null;
//        while(queue.size()>0){
//            if(head==null){
//                head=queue.poll();
//                root=head;
//            }
//            head.next=queue.poll();
//            head=head.next;
//        }
//        return root;
//    }
//
//    public static void main(String[] args) {
//        ListNode head = new ListNode(4);
//        head.next=new ListNode(2);
//        head.next.next=new ListNode(1);
//        head.next.next.next=new ListNode(3);
//        head=sortList(head);
//        while(head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }
//    }
//}
public class sortList {
    public static ListNode sortList(ListNode head){

        Map<Integer,Integer> map=new HashMap<>();


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        minHeap.toArray();
        Arrays.sort(new int[12]);
        if(head==null||head.next==null)
            return head;
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next != null&&fast.next.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        //此时当链表长度为奇数时候slow刚好停在中点位置，当链表为偶数时候，slow停在n/2处
        ListNode right=slow.next;
        slow.next=null;
        head=sortList(head);
        right=sortList(right);
        return merge(head,right);
    }
    public static ListNode merge(ListNode left,ListNode right){
        if(left==null)
            return right;
        if(right==null)
            return left;
        ListNode head;
        if(left.val<=right.val) {
            head = left;
            head.next=merge(left.next,right);
        }else{
            head=right;
            head.next=merge(left,right.next);
        }
        return head;
    }
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next=new ListNode(2);
//        head.next.next=new ListNode(5);
//        head.next.next.next=new ListNode(4);
//        ListNode head2 = new ListNode(1);
//        head2.next=new ListNode(3);
//        head2.next.next=new ListNode(2);
//        head2.next.next.next=new ListNode(5);
//       // head=merge(head,head2);
//        head=sortList(head);
//        while(head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }
        sortList sortList=new sortList();

        int[] test=new int[]{-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
//        sortList.topKFrequent(test,1);
        sortList.fourSum(test,294967296);

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numsMap=new HashMap();
        for(int i:nums){
            numsMap.put(i, numsMap.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2-i1);
        for(int index:numsMap.keySet()){
            int val=numsMap.get(index);
            maxHeap.add(index);
        }
//        maxHeap.offer()
        return new int[0];
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4) return new ArrayList();
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList();
        int one=0,two=0,three=0,four=0;
        for(one =0;one<nums.length-3;one++){
            //去重
            if(one>0 && nums[one] ==nums[one-1]){
                continue;
            }
            //剪枝,解决溢出
            if(nums[one]*1L + nums[one+1] + nums[one+2] +nums[one+3] > target){
                break;
            }

            for(two=one +1;two<nums.length-2;two++){
                if(two>one+1 && nums[two] ==nums[two-1]){
                    continue;
                }

                long temp=target*1L-nums[one]-nums[two];

                three=two+1;
                four=nums.length-1;
                while(three<four){
                    if(nums[three]*1L+nums[four]<temp){
                        three++;
                    }else if(nums[three]*1L+nums[four] > temp){
                        four--;
                    }else{
                        while (three < four && nums[three] == nums[three + 1]) three++;
                        while (three < four && nums[four] == nums[four - 1]) four--;
                        List<Integer> tempList=new ArrayList();
                        Collections.addAll(tempList, nums[one], nums[two], nums[three], nums[four]);
                        result.add(tempList);
                        three++;
                        four--;
                    }
                }

            }
        }
        return result;
    }
}
