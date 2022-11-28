public class isMatch_10 {
    public boolean isMatch(String s,String p){

//wrong code
//        if(p.isEmpty()) return s.isEmpty();
//        //首字符匹配情况
//        boolean first=(!s.isEmpty())&&(p.charAt(0)=='.'||p.charAt(0)==s.charAt(0));
//        //之后看p的第二位是不是*号
//        //S:aaaac
//        //P:a*c
//        //如果是*号，将s中的所有重复位删除，再匹配
//        if(p.length()>1&&p.charAt(1)=='*'){
//            int sameLength=0;
//            while(sameLength<s.length()&&(s.charAt(0)==s.charAt(sameLength)||p.charAt(0)=='.'))
//                sameLength++;
//            return (first&&isMatch(s.substring(sameLength),p.substring(2)))||(isMatch(s,p.substring(2)));
//        }else{
//            return isMatch(s.substring(1),p.substring(1));
//        }
    //动规

        //f[i][j]表示s的前i个字符和p的前j个字符能否匹配
        //
        return false;
    }

    public static void main(String[] args) {
        String s="s";
        System.out.println(s.substring(1));
    }
}
