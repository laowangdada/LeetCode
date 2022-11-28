import BST.BinarySearchTree;

public class closestDivisors_5171 {
    public int[] closestDivisors(int num) {
        int num1=num+1;
        int num2=num+2;
        int[] distance1=closest(num1);
        int[] distance2 = closest(num2);
        return (Math.abs(distance1[1]-distance1[0])<Math.abs(distance2[1]-distance2[0]))?distance1:distance2;

    }

    public int[] closest(int n){
        int board= (int) Math.sqrt(n);
        int[] result=new int[2];
        while(board>0){
            if(n%board==0){
                result[0]=board;
                result[1] = n/board;
                return result;
            }
            board--;
        }
        return result;
    }






    public static void main(String[] args) {
        closestDivisors_5171 temp=new closestDivisors_5171();
        int[] result= temp.closestDivisors(999);
        System.out.print(result[0]+" ");
        System.out.println(result[1]);


        try {
            Class aClass= Class.forName("BST.BinarySearchTree");
            BinarySearchTree bs= (BinarySearchTree) aClass.newInstance();
            String className =bs.getClass().getName();
            System.out.println(className);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
