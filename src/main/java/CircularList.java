//Circuiar list using simple ArrayList

public class CircularList {

    int capacity;
    int startIndex;
    int endIndex;
    int[] myList;

    public static void main(String[] args) {
        CircularList list = new CircularList(8);
        for(int i=0; i< list.capacity; i++) {
            list.insertAtEnd(i);
        }
        list.insertAtEnd(10);

        for(int i=0; i< 5; i++) {
            System.out.println("Deleted Element" + list.deleteFromStart());
            list.printElements();
        }

        for(int i=0; i< list.capacity; i++) {
            list.insertAtEnd(i);
        }
        list.insertAtEnd(10);

        for(int i=0; i< list.capacity; i++) {
            System.out.println("Deleted Element" + list.deleteFromStart());
            list.printElements();
        }

        list.deleteFromStart();
    }

    public CircularList(int capacity) {
        this.capacity = capacity;
        this.startIndex =0;
        this.endIndex =0;
        this.myList = new int[capacity];
    }

    public boolean isFull(){
        return Math.abs(startIndex - endIndex) == (capacity-1);
    }

    public boolean isEmpty(){
        return startIndex == endIndex;
    }

    public void insertAtEnd(int elem) {
        if(isFull()) {
            System.out.println("Capacity is full ! ");
            return;
        }
        endIndex = (endIndex +1) % capacity;
        myList[endIndex] = elem;
    }

    public int deleteFromStart() {
        if(isEmpty()) {
            System.out.println("List is empty");
            return -1;
        }
        int value = myList[startIndex];
        startIndex = (startIndex +1) % capacity;
        return value;
    }

    public void printElements() {
        int elem = startIndex;
        int size = Math.abs(startIndex - endIndex);
        for(int I=0; I<size; I++) {
            System.out.print(myList[elem] + " ");
            elem = (elem+1) % capacity;
        }
    }

}