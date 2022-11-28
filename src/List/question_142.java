package List;
import	java.util.ArrayList;
import	java.util.LinkedList;
import	java.util.HashSet;
import	java.util.Set;
import	java.util.HashMap;
import	java.util.Map;

public class question_142 {
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> all = new HashSet<> ();
//        ListNode cur=head;
//        while (cur!=null){
//            if(all.contains(cur)){
//                return cur;
//            }
//            all.add(cur);
//            cur=cur.next;
//        }
//        return null;
//    }
//设环的起始节点为 E，快慢指针从 head 出发，快指针速度为 2，设相交节点为 X，
// head 到 E 的距离为 H，E 到 X 的距离为 D，环的长度为 L，
// 那么有：快指针走过的距离等于慢指针走过的距离加快指针多走的距离（多走了 n 圈的 L）
// 2(H + D) = H + D + nL，因此可以推出 H = nL - D，
// 这意味着如果我们让俩个慢指针一个从 head 出发，一个从 X 出发的话，他们一定会在入口节点 E 相遇

    public ListNode detectCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        boolean flag=false;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
            if(fast==slow){
                flag=true;
                break;
            }
        }
        if(flag){
            fast=head;
            while (fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
        return null;
    }
}
