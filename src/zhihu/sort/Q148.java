package zhihu.sort;

public class Q148 {
    //O(nlogn) O(1)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHead = slow.next;
        slow.next = null; // cut list

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (h1 != null & h2 != null){
            if(h1.val<h2.val){
                p.next=h1;
                h1=h1.next;
            }else {
                p.next=h2;
                h2=h2.next;
            }
            p=p.next;
        }
        if(h1!=null) p.next=h1;
        if(h2!=null) p.next=h2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head.next.next.next =new ListNode(3);
        new Q148().sortList(head);
    }
}
