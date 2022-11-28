import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class daysBetweenDates_5169 {
    public int daysBetweenDates(String date1,String date2)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate1;
        try {
            myDate1 = sdf.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
        Date myDate2;
        try {
            myDate2 = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
        return (int) (Math.abs(myDate1.getTime() - myDate2.getTime())/(1000*3600*24));
    }

    public static void main(String[] args) {
        daysBetweenDates_5169 temp=new daysBetweenDates_5169();
        int a=temp.daysBetweenDates("1998-09-12","2000-12-12");
        System.out.println(a);
    }
}
