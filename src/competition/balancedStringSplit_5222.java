package competition;

public class balancedStringSplit_5222 {
    public int balancedStringSplit(String s) {
        int Lcount=0;
        int Rcount=0;
        int result=0;
        for(char c : s.toCharArray()){
            if(c=='L')
                Lcount++;
            else
                Rcount++;
            if(Lcount==Rcount){
                result++;
                Lcount=0;
                Rcount=0;
            }
        }
        return result;
    }
}
