//Tribonacci numbers

public class Tribonacci {

    public static void main(String[] args) {
        int n = 10;

        int t1 = 0, t2 = 0, t3 = 1;
        System.out.print("Series : " + t1 + "," +t2 + "," +t3);
        for (int i = 3; i < n; i++) {
            int t4 = t1 + t2 + t3;
            System.out.print("," + t4);
            t1 = t2;
            t2 = t3;
            t3 = t4;
        }
        System.out.println(" Fib recursion Series : ");
        for(int i = 0; i < 10; i++) {
            System.out.print(Tribonacci.fib(i) + " ");
        }

        System.out.println(" Tribonacci recursion Series : ");
        for(int i = 0; i < 10; i++) {
            System.out.print(Tribonacci.fib(i) + " ");
        }
    }

    public static int fib(int n) {
        if(n==1) {
            return n;
        }
        if (n==0) {
            return n;
        }

        return  fib(n-2) + fib(n-1);
    }
}