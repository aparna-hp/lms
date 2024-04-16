package LinkedList;

import java.net.Inet4Address;
import java.util.Stack;

public class ReverseList {

    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        reverseList(list);
        list.print();
        reverseInPlace(list);
        list.print();
    }

    public static void reverseList(LinkedListImpl list) {
        Stack<Integer> myStack = new Stack<>();
        while(!list.isEmpty()) {
            myStack.push(list.deleteFromHead());
        }

        while(!myStack.isEmpty()) {
            list.add(myStack.pop());
        }
    }

    public static void reverseInPlace(LinkedListImpl list) {
        if(list.isEmpty()) {
            return;
        }

        Node prev = null;
        Node curr = list.head;//1
        Node next ;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
    }
}
