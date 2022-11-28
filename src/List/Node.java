package List;

public class Node {
    public int val;
    public Node prev;
    public Node next;

    Node(){
        this.next=this.prev=this;
        this.val=-1;
    }
    Node(int value){
        this.val=value;
    }

    public void add(Node newNode){
        prev.next=newNode;
        newNode.prev=prev;

        newNode.next=this;
        prev=newNode;
    }

    public void remove(){
        this.prev.next=this.next;
        this.next.prev=this.prev;
        next=prev=this;
    }
}
