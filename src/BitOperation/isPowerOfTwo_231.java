package BitOperation;

public class isPowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        int i=1;
        while(i<n){
            if(i==n)
                return true;
            i=i<<1;
        }
        return false;
    }
}
