import java.util.Map;

public class test {
    public static void main(String[] args) {
//        List<Integer> list= Arrays.asList(1,2,3,4,5);
//        list.forEach(i->{
//            System.out.println(i);
//        });
//        list.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });
        new Child();
    }
}


class Parent {
    static {
        System.out.println("Parent static initial block");   //first
    }

    public static void load(Map<Integer, Parent> a){
        System.out.println("111");
    }

    {
        System.out.println("Parent initial block");
    }

    public Parent() {
        System.out.println("Parent constructor block");// second

    }
}

class Child extends Parent {
//    public static void load(Map<Integer, Child> a){
//        System.out.printf("fjklds");
//    }

    public Child() {
        System.out.println("Child constructor block");
    }
    static {
        System.out.println("Child static initial block");
    }
    private Hobby hobby = new Hobby();
    {
        System.out.println("Child initial block");
    }



}

class Hobby {
    static{
        System.out.println("Hobby static initial block");
    }

    public Hobby() {
        System.out.println("hobby constructor block");
    }
}