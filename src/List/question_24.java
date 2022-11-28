package List;

public class question_24 {
    public static ListNode swapPairs(ListNode head) {
//        当空或者只有一个元素时候
        if(head==null || head.next==null){
            return head;
        }
        ListNode myhead=head.next;//最后要返回的头节点
        ListNode temp;
        ListNode temp2;
        ListNode pre=new ListNode(0);
        pre.next=head;
        while ((head!=null) && (head.next!=null)){
            temp=head.next.next;
            temp2=head.next;
            head.next=temp;
            temp2.next=head;//每次交换,当前head节点的下一节点变成头节点
            pre.next=temp2;//所以把上个节点的next指针指向它
            head=temp;//移动head节点
            pre=temp2.next;//移动尾节点,注意要把上次的尾结点,连接到这一次的头节点
        }
        return myhead;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        a.next=new ListNode(2);
        a=swapPairs(a);
        while (a!=null){
            System.out.println(a.val);
            a=a.next;
        }
    }
}
