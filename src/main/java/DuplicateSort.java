import java.util.Arrays;

public class DuplicateSort {

    public  static void main(String[] args){
        int[] input =  {1, 2, 4, 3, 5, 4, 3};
        int N = 7;

        System.out.println("Sorted array " + Arrays.toString(mergeSort(input, N)));

    }

    public static int[] mergeSort(int[] input, int N) {
        if(N ==1 || N ==0) {
            return input;
        }

        int[] left = new int[N/2];
        for(int x =0; x< N/2; x++) {
            left[x] = input[x];
        }
        left = mergeSort(left, N/2);

        int[] right = new int[N-N/2];
        for(int x=N/2; x<N; x++) {
            right[x-N/2] = input[x];
        }
        right = mergeSort(right, N-N/2);
        return merge(left, right, N);
    }

    public static int[] merge(int[] left, int[] right, int N) {
        int x =0, y =0, z =0;
        int[] out = new int[N];

        while(x < left.length && y < right.length) {
            if( left[x] < right[y] ) {
                out[z++] = left[x++];
            } else if ( left[x] > right[y] ) {
                out[z++] = right[y++];
            } else {
                if(z == 0 || out[z-1] != left[x]) {
                    out[z++] = left[x];
                }
                x++;
                y++;
            }
        }

        while(x < left.length) {
            if(z == 0 || out[z-1] != left[x]) {
                out[z++] = left[x];
            }
            x++;
        }

        while(y < right.length) {
            if(z == 0 || out[z-1] != right[y]) {
                out[z++] = right[y];
            }
            y++;
        }
        return out;
    }
}