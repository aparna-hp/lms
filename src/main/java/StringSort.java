//Sort strings

import java.util.*;

        public class StringSort {

            public static void main(String[] args) {
                String[] stringArray = {"Peacock", "Tiger", "Owl", "Goat", "Deer"};
                System.out.println("Sorted Array = " + Arrays.toString(mergeSort(stringArray, stringArray.length)));
            }

            public static String[] mergeSort(String[] strArr, int n) {
                if (n == 1 || n == 0) {
                    return strArr;
                }

                String[] left = new String[n / 2];
                for (int I = 0; I < n / 2; I++) {
                    left[I] = strArr[I];
                }
                System.out.println("Left arr  " + Arrays.toString(left));
                left = mergeSort(left, n / 2);

                String[] right = new String[n - n / 2];
                for (int I = n / 2; I < n; I++) {
                    right[I - n / 2] = strArr[I];
                }
                System.out.println("Right arr  " + Arrays.toString(right));
                right = mergeSort(right, n - n / 2);

                System.out.println("Merging Left " + Arrays.toString(left) + " and " + Arrays.toString(right));
                return merge(left, right, n);
            }

            public static String[] merge(String[] left, String[] right, int n) {
                String[] sortArr = new String[n];
                int leftIndex = 0, rightIndex = 0, sortIndex = 0;
                while (leftIndex < left.length && rightIndex < right.length) {
                    System.out.println("Comparing " + left[leftIndex] + " and " + right[rightIndex]);
                    if (left[leftIndex].length() < right[rightIndex].length()) {
                        System.out.println("Copying " + left[leftIndex]);
                        sortArr[sortIndex] = left[leftIndex];
                        leftIndex++;
                        sortIndex++;
                    } else if (left[leftIndex].length() > right[rightIndex].length()) {
                        System.out.println("Copying " + right[rightIndex]);
                        sortArr[sortIndex] = right[rightIndex];
                        rightIndex++;
                        sortIndex++;
                    } else if (left[leftIndex].equals(right[rightIndex])) {
                        System.out.println("Copying " + right[rightIndex]);
                        sortArr[sortIndex] = right[rightIndex];
                        rightIndex++;
                        leftIndex++;
                        sortIndex++;
                    } else {
                        for (int I = 0; I < left[leftIndex].length(); I++) {
                            System.out.println("Comparing characters at length " + I);
                            char leftChar = left[leftIndex].charAt(I);
                            char rightChar = right[rightIndex].charAt(I);

                            if (leftChar < rightChar) {
                                System.out.println("Copying " + left[leftIndex]);
                                sortArr[sortIndex] = left[leftIndex];
                                leftIndex++;
                                sortIndex++;
                                break;
                            } else if (rightChar < leftChar) {
                                System.out.println("Copying " + right[rightIndex]);
                                sortArr[sortIndex] = right[rightIndex];
                                rightIndex++;
                                sortIndex++;
                                break;
                            } else {
                                System.out.println("Copying " + right[rightIndex]);
                                sortArr[sortIndex] = right[rightIndex];
                                rightIndex++;
                                sortIndex++;
                                leftIndex++;
                            }

                        }
                    }
                }

                while (leftIndex < left.length) {
                    System.out.println("Copying " + left[leftIndex]);
                    sortArr[sortIndex] = left[leftIndex];
                    leftIndex++;
                    sortIndex++;
                }

                while (rightIndex < right.length) {
                    System.out.println("Copying " + right[rightIndex]);
                    sortArr[sortIndex] = right[rightIndex];
                    rightIndex++;
                    sortIndex++;
                }
                return sortArr;
            }
        }