public class toHexspeak_5112 {
    public static String toHexspeak(String num){
        Long num1=Long.parseLong(num);
        String strHex=Long.toHexString(num1).toUpperCase();
        char[] str = strHex.toCharArray();
        for(int i=0;i<strHex.length();i++){
            if(str[i]<='9'&&str[i]>='2')
                return "ERROR";
            else if(str[i]=='1')
                str[i]='I';
            else if(str[i]=='0')
                str[i]='O';
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(toHexspeak("12312434343"));
    }
}
