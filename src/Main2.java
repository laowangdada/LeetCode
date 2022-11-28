public class Main2 {
    public boolean isNumber(String s) {
        if(s==null || s.length()==0){
            return false;
        }
        int start=0, end=s.length()-1;
        int dotTime=0;
        int eTime=0;
        boolean  signCanAppear=true;
        boolean needNum=true;

        // remove blank space
        while(start<=end && s.charAt(start)==' '){
            start++;
        }
        while(end >=0 && s.charAt(end)==' '){
            end--;
        }

        for(int i=start;i<=end;i++){
            if(s.charAt(i)=='.'){
                dotTime++;
                if(eTime>0 || dotTime>1){
                    return false;
                }
            }else if(s.charAt(i)=='e' || s.charAt(i)=='E'){
                eTime++;
                if(eTime>1){
                    return false;
                }
                if(needNum==true){
                    return false;
                }
                needNum = true;
            }else if(s.charAt(i)=='-' || s.charAt(i)=='+'){
                if(i!=start && s.charAt(i-1)!='e' && s.charAt(i-1)!='E'){
                    return false;
                }
                needNum=true;
            }
            else if(isNum(s.charAt(i))){
                needNum=false;
            }else{
                return false;
            }
        }
        return  needNum?false:true;
    }

    public boolean isNum(char a){
        return a>='0' && a <='9';
    }
    public static void main(String[] args) {
        Main2 main2 = new Main2();
//        System.out.println(main2.isNumber("-1E-16"));

        String a = "abjl ksj glk gjg hsdf";
        a=a.replace("abjl","hi");
        a=a.replace("ksj","YOU");
        System.out.println(a);
    }
}
