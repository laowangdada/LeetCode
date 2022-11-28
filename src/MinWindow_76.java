import java.util.HashMap;


public class MinWindow_76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> helper = new HashMap<> ();
        for(char c:s.toCharArray()) helper.put(c,0);
        for(char c:t.toCharArray()){
            if(helper.containsKey(c))
                helper.put(c,helper.get(c)+1);
            else
                return "";//t中有字符s中没有，直接返回空串
        }
        int start=0,end=0;//滑动窗口的，开始和结尾
        int minLen=Integer.MAX_VALUE;
        int counter=t.length();
        while(end<t.length()){

        }
        return "";
    }
}
