//Clockwise traversal of MxN matrix boundary

import java.util.ArrayList;
import java.util.List;

public class Matric {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}, {7,8,9},{10,11,12}};
        spiralMatric(arr);
        System.out.println("X = " + findX(28));
        System.out.println("Border printing :");
        int N = arr.length;
        int M = arr[0].length;
        for(int i=0; i<M; i++) {
            System.out.print(arr[0][i] + " ");
        }

        for(int i=1; i<N; i++) {
            System.out.print(arr[i][M-1] + " ");
        }

        for(int i=M-2; i >=0; i-- ) {
            System.out.print(arr[N-1][i] + " ");
        }

        for(int i=N-2; i>0; i--){
            System.out.print(arr[i][0] + " ");
        }

        List<Integer> myList = new ArrayList<>();
    }

    public static void spiralMatric(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int shiftRow = 0;
        int shiftCol = 0;
        int count =0, maxCount = M*N;
        while (shiftRow <= N/2 && shiftCol <= M/2) {
            for (int i = shiftRow; i < M-shiftCol; i++) {
                System.out.print(arr[shiftRow][i] + " ");
                count++;
            }
            if(count == maxCount) break;

            for (int i = shiftRow+1; i < N-shiftRow; i++) {
                System.out.print(arr[i][M-shiftCol- 1] + " ");
                count++;
            }
            if(count == maxCount) break;

            for (int i = M - shiftCol - 2; i > shiftCol; i--) {
                System.out.print(arr[N -shiftRow - 1][i] + " ");
                count++;
            }
            if(count == maxCount) break;

            for (int i = N -shiftRow- 1; i > shiftRow; i--) {
                System.out.print(arr[i][shiftRow] + " ");
                count++;
            }
            if(count == maxCount) break;
            shiftCol++;
            shiftRow++;
        }
    }

    public static int findX(int k) {
        //find X for K = x^2 + 3x
        double maxValue = Math.sqrt(k);
        for(int i = (int)maxValue; i >=1 ;i--) {
            int temp = (i * i) + 3*i;
            if(k == temp) {
                return i;
            }
        }
        return -1;
    }
}