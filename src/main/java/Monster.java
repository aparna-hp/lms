//Monster problem

import java.util.Scanner;

public class Monster{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the num of elements N: ");
        int num = scanner.nextInt();
        int[] A = new int[num+1];
        System.out.println("Enter the" + (num+1) + "  entries for array A : ");
        for(int I=0; I < num+1; I++) {
            A[I] = scanner.nextInt();
        }
        int[] B = new int[num];
        System.out.println("Enter the" + num + "  entries for array B : ");
        for(int I=0; I<num; I++) {
            B[I] = scanner.nextInt();
        }

        int lend = 0;
        int max = 0;
        for(int I=0; I<num; I++) {
            int capacity = B[I] + lend;
            if(capacity > A[I]) {
                lend = capacity - A[I];
                max += A[I];
            } else {
                lend = 0;
                max += capacity;
            }
        }
        max += Math.min(lend, A[num]);
        System.out.println(" Result = " + max);
    }
}

