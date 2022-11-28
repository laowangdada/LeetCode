import java.util.ArrayDeque;


public class simplifyPath_200 {
    public static String simplifyPath(String path) {
        String[] tempPath=path.split("/");
        ArrayDeque<String> result=new ArrayDeque<>();
        for(String s : tempPath){
            if(!result.isEmpty()&&s.equals(".."))
                result.removeLast();
            else if(!s.equals("")&&!s.equals(".")&&!s.equals(".."))
                result.addLast(s);
        }
        if(result.isEmpty())
            return "/";
        StringBuilder finalResult= new StringBuilder();
        for(String s:result){
            finalResult.append("/"+s);
        }
        return finalResult.toString();
    }

    public static void main(String[] args) {
        String a="/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
        String b=simplifyPath(a);
        System.out.println(b);
    }
}
