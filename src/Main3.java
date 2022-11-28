import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<value> all = new ArrayList<>();
        int x = 0;
        int h = 0;
        for (int i = 0; i < num; i++) {
            x = in.nextInt();
            h = in.nextInt();
            all.add(new value(x, h));
        }
        Collections.sort(all, new Comparator<value>() {
            @Override
            public int compare(value o1, value o2) {
                if (o1.x > o2.x)
                    return 1;
                else if (o1.x == o2.x)
                    return 0;
                else
                    return -1;
            }
        });
        int length=1;
        for (int i=0;i<all.size()-1;i++) {
            if(all.get(i).h<=all.get(i+1).h)
                length++;
            else
                break;
        }
        System.out.println(length);
    }
}


class value{
    public int x;
    public int h;
    public value(int X,int H){
        this.x=X;
        this.h=H;
    }
}
