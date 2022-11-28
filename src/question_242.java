import java.util.HashMap;
import java.util.HashSet;

public class question_242 {
//    public boolean isAnagram(String s, String t) {
//        HashMap<Character,Integer> volume=new HashMap<>();
//        int temp=0;
//        for (int i=0;i<s.length();i++){
//            if(volume.containsKey(s.charAt(i))==true)
//                volume.put(s.charAt(i),volume.get(s.charAt(i))+1);
//            else{
//                volume.put(s.charAt(i),1);
//            }
//        }
//        for (int i=0;i<t.length();i++){
//            if(volume.containsKey(t.charAt(i))==false)
//                return false;
//            else{
//                temp=volume.get(t.charAt(i))-1;
//                if(temp<0)
//                    return false;
//                else
//                    volume.put(t.charAt(i),temp);
//            }
//        }
//        for(Integer n:volume.values()){
//            temp=temp+n;
//        }
//        if(temp==0)
//            return true;
//        else
//            return false;
//    }
//    使用foreach会更快一点，比如使用string.toCharArray然后用foreach遍历则更快
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int []character=new int[26];
    for(int i=0;i<s.length();i++){
        character[s.charAt(i)-'a']++;
    }

    int a=0;
    for(int i=0;i<t.length();i++){
        character[t.charAt(i)-'a']--;
        if(character[t.charAt(i)-'a']<0)
            return false;
    }
    return true;
}
}
