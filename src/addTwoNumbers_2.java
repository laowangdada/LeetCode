import List.ListNode;

public class addTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode head=null;
        ListNode cur=null;
        int carry=0;
        while(l1!=null||l2!=null){
            int a=(l1!=null)?l1.val:0;
            int b=(l2!=null)?l2.val:0;
            int units=(a+b+carry)%10;
            carry =(a+b+carry)>9?1:0;
            if(head==null){
                head=new ListNode(units);
                cur=head;
            }else{
                cur.next=new ListNode(units);
                cur=cur.next;
            }
            l1=(l1!=null)?l1.next:null;
            l2=(l2!=null)?l2.next:null;
        }
        if(carry==1)
            cur.next=new ListNode(carry);
        return head;
    }
}
