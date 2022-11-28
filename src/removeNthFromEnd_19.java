
import List.ListNode;

import java.util.ArrayList;

public class removeNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ArrayList<ListNode> list = new ArrayList<> ();
        ListNode cur=head;
        int length=0;
        while(cur!=null){
            list.add(cur);
            cur=cur.next;
            length++;
        }
        int index=length - n-1;
        if(index==-1){
            head=head.next;
            return head;
        }
        cur=list.get(index);
        ListNode temp=cur.next.next;
        cur.next.next=null;
        cur.next=temp;
        return head;
    }
}
