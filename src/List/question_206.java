package List;
public class question_206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode prev=null;
        return help_fun(cur,prev);
    }
    public ListNode help_fun(ListNode cur,ListNode prev){
        if(cur==null){
            return prev;
        }
        ListNode temp=cur.next;
        cur.next=prev;
        ListNode newhead=help_fun(temp,cur);
        return newhead;
    }
}