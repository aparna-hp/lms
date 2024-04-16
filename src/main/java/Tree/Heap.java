package Tree;


import java.util.Arrays;

public class Heap {

   int[] maxHeap;
   int size;

   public Heap() {
       maxHeap = new int[100];
       size =0;
   }

   public static void main(String[] args){
       Heap heap = new Heap();
       heap.addNode(4);
       heap.addNode(14);
       heap.addNode(10);
       heap.addNode(12);
       heap.addNode(8);


       System.out.println(Arrays.toString(heap.maxHeap));
       heap.deleteRoot();
       System.out.println( "After root delete :" + Arrays.toString(heap.maxHeap));

       heap.deleteRoot();
       System.out.println( "After root delete :" + Arrays.toString(heap.maxHeap));

       int[] inputArr = new int[] {3,10,6,4,15};
       heap.heapSort(inputArr);
       System.out.println("Sorted Arr " + Arrays.toString(inputArr) );

       inputArr = new int[] {3,10,6,4,15,1};
       System.out.println(heap.kthSmallest(inputArr, 4));
   }

   public void addNode(int value) {
       maxHeap[size] = value;
       heapifyFromButtom(size);
       size++;
   }

   public void deleteRoot(){
       if(size > 1) {
           size--;
           maxHeap[0] = maxHeap[size];
           maxHeap[size] = 0;
           heapifyFromRoot(0);
       } else {
           maxHeap[0] = 0;
       }
   }

   public void deleteNode(int value){


   }

   public void searchHeap(int value){

   }

   public void heapifyFromButtom(int index) {
       if (index == 0) {
           return;
       }
       int parent = (index -1)/2;
       if(maxHeap[index] > maxHeap[parent]) {
           //swap the parent and index values
           int temp = maxHeap[parent];
           maxHeap[parent] = maxHeap[index];
           maxHeap[index] = temp;
           heapifyFromButtom(parent);
       }
   }

   public void heapifyFromRoot(int index){
       if(index > size){
           return;
       }
       int left = index*2 + 1;
       int right = index*2 +2;

       int swapIndex = index;
       if((left < size && maxHeap[left] > maxHeap[index])) {
           swapIndex = left;
       }

       if(right < size && maxHeap[right] > maxHeap[swapIndex]) {
           swapIndex = right;
       }

       if(swapIndex != index) {
           int temp = maxHeap[swapIndex];
           maxHeap[swapIndex] = maxHeap[index];
           maxHeap[index] = temp;
           heapifyFromRoot(swapIndex);
       }
   }

   public void heapSort(int[] inputArr){
       maxHeap = new int[inputArr.length];
       size = 0;
       for (int val : inputArr) {
           addNode(val);
       }

       System.out.println("Max heap " + Arrays.toString(maxHeap));
       int i=0;

       while(size > 1) {
           System.out.println("Max heap " + Arrays.toString(maxHeap));
           inputArr[i] = maxHeap[0];
           deleteRoot();
           i++;
       }

       System.out.println("Max heap " + Arrays.toString(maxHeap));
       inputArr[i] = maxHeap[0];
   }

   public int kthSmallest(int[] inputArr, int k) {
       maxHeap = new int[k];
       size =0;
       for(int i=0; i< inputArr.length; i++) {
           if(i<k) {
               addNode(inputArr[i]);
           } else {
               if(maxHeap[0] > inputArr[i]) {
                   deleteRoot();
                   addNode(inputArr[i]);
               }
           }
           System.out.println(Arrays.toString(maxHeap));
       }
       return maxHeap[0];
   }

    
}
