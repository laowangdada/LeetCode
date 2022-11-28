import java.util.HashMap;

public class lengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s){
        if(s.length()==0) return 0;
        HashMap<Character, Integer> map=new HashMap<>();
        int maxLength=0;
        int left=0;
//使用hashmap key：字符 value：下标
        for(int i=0;i<s.length();i++){
            //如果字符已经存在,找到那个存在的字符下标++；
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                left=Math.max(left,map.get(s.charAt(i)+1));
            }
            map.put(s.charAt(i),i);
            maxLength=Math.max(maxLength,i-left+1);//保存最大值
        }
        return maxLength;
    }
}
