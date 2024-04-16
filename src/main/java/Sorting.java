//Bubble sort

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Sorting {

    public static void main(String[] main) {
        int[] arr = {78,9,36, 621,5,2,1};
        bubbleSort(arr);
        int[] result = mergeSort(arr, arr.length);
        System.out.println("Sorted " + Arrays.toString(result));
    }

    public static void bubbleSort(int[] arr) {
        System.out.println("Original Array =" + Arrays.toString(arr));
        boolean swap = true;
        while(swap) {
            for(int I =1; I < arr.length; I++) {
                if(arr[I] < arr[I-1]) {
                    swap = true;
                    int temp = arr[I];
                    arr[I] = arr[I-1];
                    arr[I-1] = temp;
                    break;
                }
                swap = false;
            }
        }
        System.out.println("Sorted Array =" + Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr, int n) {

        if(n == 1)
            return arr;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        for(int i=0; i < mid; i++ ){
            left[i] = arr[i];
        }

        for(int i=mid, j=0; i < n; i++,j++) {
            right[j] = arr[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);
        return merge(left, right);
    }


    public static int[] merge(int[] A, int[] B) {

        int sizeA = A.length;
        int sizeB = B.length;
        int[] result = new int[sizeA + sizeB];
        int I = 0, j = 0, x = 0;
        while(I < sizeA && j < sizeB) {
            if(A[I]< B[j]) {
                result[x] = A[I];
                I++;
            }
            else if(A[I] > B[j]){
                result[x] = B[j];
                j++;
            } else {
                result[x] = A[I];
                I++;
                j++;
            }
            x++;
        }

        while(I < sizeA) {
            result[x] = A[I];
            I++;
            x++;
        }

        while(j < sizeB) {
            result[x] = B[j];
            j++;
            x++;
        }
        return result;
    }

    public static List<Integer> mergeSortList(List<Integer> list) {
        if(list.size() == 1) {
            return list;
        }
        int mid = list.size()/2;
        List<Integer> left = list.subList(0,mid);
        List<Integer> right = list.subList(mid+1, list.size()-1);
        return merge(left,right);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> leftIterator = left.listIterator();
        Iterator<Integer> rightIterator = right.listIterator();
        int leftValue = leftIterator.next();
        int rightValue = rightIterator.next();
        while(leftIterator.hasNext() && rightIterator.hasNext()) {
            if(leftValue < rightValue) {
                result.add(leftValue);
                leftValue = leftIterator.next();
            } else if(leftValue > rightValue) {
                result.add(rightValue);
            }
        }
        return result;
    }

}