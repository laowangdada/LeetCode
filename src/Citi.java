import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Citi {

    public static boolean checkValue(String word) {
        Pattern pattern= Pattern.compile("[(ci)|(ti)|(bank)]*");
        Matcher m=pattern.matcher(word);
        return m.find();
    }

    public static String checkValue2(String word) {
        char[] wordChars=word.toCharArray();
        Stack<Character> temp=new Stack<>();
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < wordChars.length; i++) {
            if(wordChars[i]!='*'&&wordChars[i]!=']') temp.push(wordChars[i]);
        }
        while(!temp.empty()){
            if(temp.peek()==']'){
                temp.pop();
            }
            StringBuilder sb=new StringBuilder();
            while(temp.peek()!='[') {
                sb.append(temp.pop());
            }
            temp.pop();
            sb.reverse();
            String inside=sb.toString();
            if(temp.peek()<58&&temp.peek()>47) {
                int times= temp.pop()-48;
                for (int j = 0; j < times-1; j++) {
                    sb.append(inside.toCharArray());
                }
            }
            result.append(sb.toString());
        }
        return result.toString();
        }



    public static void main(String[] args) {
//        System.out.println(checkValue2("2*[a2[b]]"));
        System.out.println(checkValue("2*[a2[b]]"));
//        checkValue
    }
}
