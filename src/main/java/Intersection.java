//Intersection of sorted A and unsorted B into sorted C

import java.util.*;

        public class Intersection {

            public static void main(String[] args) {
                int[] A = {2, 4, 6, 8, 10, 11};
                int[] B = {11, 9, 10, 6, 3, 4, 2};
                approach1(A, B); // O(NLogN)
                approach2(A, B);
            }

            public static void approach1(int[] A, int[] B) {
                int sizeA = A.length;
                int sizeB = B.length;
                int sizeC = Math.max(sizeA, sizeB);
                int[] C = new int[sizeC];

                Arrays.sort(B); //in Olog(N)
                //2,3,4,6,9,10,11

                //O(N)
                for(int i =0, j=0, z=0; i < sizeA && j < sizeB; ) {
                    if(A[i] == B[j]) {
                        C[z] = A[i];
                        z++;
                        i++;
                        j++;
                    } else if (A[i] < B[j]) {
                        i ++;
                    } else {
                        j++;
                    }
                }

                System.out.println(Arrays.toString(C));
            }

            public static void approach2(int[] A, int[] B) {
                int sizeA = A.length;
                int sizeB = B.length;
                int sizeC = Math.max(sizeA, sizeB);
                int[] C = new int[sizeC];

                Map<Integer, Boolean> myMap = new HashMap<>();
                for (int i : A) {
                    if (!myMap.containsKey(i)) {
                        myMap.put(i, true);
                    }
                }

                int cIndex = 0;
                for (int I : B) {
                    if (myMap.containsKey(I) && myMap.get(I)) {
                        myMap.put(I, false);
                        int insertIndex = cIndex;
                        while (insertIndex > 0 && I < C[insertIndex - 1]) {
                            C[insertIndex] = C[insertIndex - 1];
                            insertIndex--;
                        }
                        C[insertIndex] = I;
                        cIndex++;
                    }
                }

                System.out.println(Arrays.toString(C));
            }
        }