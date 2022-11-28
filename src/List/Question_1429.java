package List;

import java.util.HashMap;
import java.util.Map;

public class Question_1429 {

    public static void main(String[] args) {
        int nums[]=new int[]{2,3,5,2};
        FirstUnique firstUnique = new FirstUnique(nums);
    }
}


class FirstUnique {
    Map<Integer, Node> map=new HashMap();

    Node list = new Node();
    public FirstUnique(int[] nums) {
        for(int i :nums){
            add(i);
        }
    }

    public int showFirstUnique() {
        return list.next.val;
    }

    public void add(int value) {
        Node node = map.get(value);
        if(node == null) {
            node = new Node(value);
            list.add(node);
            map.put(value, node);
        } else {
            node.remove();
            node=null;
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
