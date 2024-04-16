//Median of the merged array.

public class MergedArrayMedian {

    public static void main (String[] args) {
        int[] A = {-5, 3, 6, 12, 15};
        int[]B = {-12, -10, -6, -3, 4, 10};

        int a = 0 , b = 0, c =0;
        int[] C = new int[A.length + B.length];

        while( a < A.length && b < B.length) {
            if(A[a] < B[b]) {
                C[c++] = A[a++];
            } else if( B[b] < A[a]) {
                C[c++] = B[b++];
            } else {
                C[c] = A[a];
                a++; b++; c++;
            }
        }

        while(a < A.length) {
            C[c++] = A[a++];
        }

        while(b < B.length) {
            C[c++] = B[b++];
        }

        int len = C.length;

        if(len % 2 == 0) {
            System.out.println( "Median = " + ( C [len/2] + C[len/2 -1] )/2 );
        } else {
            System.out.println( "Median = " +  C [len/2] );
        }
    }
}