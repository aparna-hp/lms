//find inversion count

import java.util.*;

        public class InversionCount {

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the num of elements:");

                int N = scanner.nextInt();
                int[] arr = new int[N];
                System.out.println("Enter the  elements of arr :");
                for (int I = 0; I < N; I++) {
                    arr[I] = scanner.nextInt();
                }

                System.out.println("No. of swaps = " + findNoOfSwaps(arr));
            }

            public static int findNoOfSwaps(int[] arr) {
                int numOfSwaps = 0;
                boolean swap = true;
                while (swap) {
                    for (int I = 0; I < arr.length - 1; I++) {
                        if (arr[I] > arr[I + 1]) {
                            swap = true;
                            numOfSwaps++;

                            //swap arr[i] and arr[i+1];
                            int temp = arr[I];
                            arr[I] = arr[I + 1];
                            arr[I + 1] = temp;
                            break;
                        }
                        swap = false;
                    }
                }
                return numOfSwaps;
            }
        }