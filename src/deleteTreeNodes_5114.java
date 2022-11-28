import java.util.*;

public class deleteTreeNodes_5114 {
    //dfs
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        //将parent转换成child形式
        Map<Integer,List<Integer>> tree=new HashMap<>();
        for(int i=1;i<parent.length;i++){
            if(!tree.containsKey(parent[i])){
                tree.put(parent[i],new ArrayList<>(Arrays.asList(i)));
            }else{
                List<Integer> temp=tree.get(parent[i]);
                temp.add(i);
                tree.put(parent[i],temp);
            }
        }
        return 0;
    }
}
