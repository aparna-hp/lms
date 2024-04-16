package LinkedList;

public class LinkedListImpl {

    Node head;

    public LinkedListImpl() {
        head = null;
    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public int deleteFromHead() {
        if(isEmpty()) {
            return -1;
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    public void delete(int value) {
        if(isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        if(head.value == value) {
            head = head.next;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            if(temp.next.value == value) {
                temp.next = temp.next.next;
            }
        }
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        return head.value;
    }

    public void print() {
        Node temp = head;
        System.out.println("The elements of the list : ");
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println(" ");

    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }
}
