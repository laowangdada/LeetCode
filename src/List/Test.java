package List;

import java.util.HashMap;
import java.util.Map;

class Test {
    public int preimageSizeFZF(int k) {
        if(k<=1) {
            return 5;
        }
        return f(k)-f(k-1);
    }

    public int f(int x){
        long left=0, right=(long) 1e10;

        while(left<right){
            long mid= left +(right-left)/2;
            long mid2 = (left + right + 1) >> 1;
            if(right>30){
                System.out.println("left1:"+left);
                System.out.println("right1:"+right);
                System.out.println(mid);
                System.out.println(mid2);
            }



            if(getCnt(mid)<= x){
                left=mid;
            }else{
                right=mid-1;
            }
        }

        return (int) right;
    }
    long getCnt(long x){
        long res=0;
        while(x!=0){
            res += x/5;
            x/=5;
        }
        return res;
    }





    public int get(int left, int right){
        long mid= left +(right-left+1)/2;
        long mid2 = (left + right + 1) >> 1;
        long mid3 = left+right >>1;

        System.out.println("left1:"+left);
        System.out.println("right1:"+right);
        System.out.println(mid);
        System.out.println(mid2);
        System.out.println(mid3);
        return 0;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,6);
        lruCache.put(1,5);
//        System.out.println(lruCache.get(1));

        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

//        lruCache.put(4,4);
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));

    }
}

class LRUCache {
    Node2 head=new Node2();
    Integer size=0;
    Map<Integer, Node2> map=new HashMap();

    public LRUCache(int capacity) {
        this.size=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node2 cur= map.get(key);
            cur.remove();
            head.add(cur);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value=value;
            return;
        }
        if(map.size()==this.size){
            map.remove(head.next.key);
            head.next.remove();
        }
        Node2 newNode=new Node2(value, key);
        map.put(key,newNode);
        head.add(newNode);
    }
}


class Node2 {
    int value;
    int key;
    Node2 next;
    Node2 prev;
    Node2(){
        this.prev=this.next=this;
        this.value = -1;
    }
    Node2(int value, int key) {
        this.value = value;
        this.key =key;
    }
    void add(Node2 n) {

        prev.next=n;
        n.prev=prev;

        n.next=this;
        this.prev=n;
    }
    void remove() {
        this.prev.next=this.next;
        this.next.prev=this.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */