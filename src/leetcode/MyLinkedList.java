package leetcode;


class MyLinkedList {

     public static void main(String[] args) {
         MyLinkedList myLinkedList=new MyLinkedList();
         myLinkedList.addAtHead(7);
         myLinkedList.addAtHead(2);
         myLinkedList.addAtHead(1);
         myLinkedList.addAtIndex(3,0);
         myLinkedList.deleteAtIndex(2);
         myLinkedList.addAtHead(6);
         myLinkedList.addAtTail(4);
         myLinkedList.get(4);
         myLinkedList.addAtHead(4);
         myLinkedList.addAtIndex(5,0);
         myLinkedList.addAtHead(6);

         myLinkedList.get(1);
     }
    int size=0;
    Node dummy=new Node(-1);
    public MyLinkedList() {

    }

    public int get(int index) {
        if(index<0||index>=size) return -1;
        Node temp=getNode(index);
        return temp.val;
    }

    public void addAtHead(int val) {
        dummy.link(new Node(val));
//        if(size==0){
//            dummy.pre=dummy.next;
//        }
        size++;
    }

    public void addAtTail(int val) {
        if(size==0){
            this.addAtHead(val);
            return;
        }
        Node newNode=new Node(val);
        dummy.pre.link(newNode);
        dummy.pre=newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index>size) return;

        if(index<=0){
            this.addAtHead(val);
            return;
        }
        if(index==size){
            this.addAtTail(val);
            return;
        }
        Node temp=getNode(index-1);
        temp.link(new Node(val));
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size) return;

        Node temp=getNode(index);
        if(temp==dummy.pre){
            dummy.pre=dummy.pre.pre;
            dummy.pre.next.delete();
        }else {
            temp.delete();
        }

        size--;
    }


    public Node getNode(int index){
        Node temp=dummy;
        while(index>=0){
            temp=temp.next;
            index--;
        }
        return temp;
    }
}
class Node{
    int val;
    Node pre;
    Node next;
    Node(int val){
        this.val=val;
        pre=next=this;
    }

    void link(Node newNode){
        newNode.next=this.next;
        this.next.pre=newNode;
        this.next=newNode;
        newNode.pre=this;
    }

    void delete(){
        this.pre.next=this.next;
        this.next.pre=this.pre;
    }
}