public class DoublyLL {
    // Head points to the start of the list
    Node head;
    // Tail points to the end of the list
    Node tail;

    // Node class for each element in the doubly linked list
    static class Node {
        String data;   // Value stored in the node
        Node next;     // Pointer to the next node
        Node prev;     // Pointer to the previous node

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Insert a node at the **front** of the list
    public static DoublyLL insertFront(DoublyLL list, String data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            // If list is empty, head and tail are the same
            list.head = list.tail = new_node;
        } else {
            // Link the new node before the current head
            new_node.next = list.head;
            list.head.prev = new_node;
            list.head = new_node;
        }
        return list;
    }

    // Insert a node at the **end** of the list
    public static DoublyLL insertEnd(DoublyLL list, String data) {
        Node new_node = new Node(data);
        if (list.tail == null) {
            // If list is empty, head and tail are the same
            list.head = list.tail = new_node;
        } else {
            // Link the new node after the current tail
            list.tail.next = new_node;
            new_node.prev = list.tail;
            list.tail = new_node;
        }
        return list;
    }

    // Delete a node from the **front** of the list
    public static DoublyLL deleteFront(DoublyLL list) {
        if (list.head == null) {
            System.out.println("List is empty");
        } else if (list.head == list.tail) {
            // Only one node exists
            list.head = list.tail = null;
        } else {
            // Move head to the next node and remove back link
            list.head = list.head.next;
            list.head.prev = null;
        }
        return list;
    }

    // Delete a node from the **end** of the list
    public static DoublyLL deleteEnd(DoublyLL list) {
        if (list.tail == null) {
            System.out.println("List is empty");
        } else if (list.head == list.tail) {
            // Only one node exists
            list.head = list.tail = null;
        } else {
            // Move tail to the previous node and remove forward link
            list.tail = list.tail.prev;
            list.tail.next = null;
        }
        return list;
    }

    // Print the list **forward** from head to tail
    public static void printForward(DoublyLL list) {
        Node curr = list.head;
        System.out.print("Forward: ");
        while (curr != null) {
            System.out.print(" <- " + curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    // Print the list **backward** from tail to head
    public static void printBackward(DoublyLL list) {
        Node curr = list.tail;
        System.out.print("Backward: ");
        while (curr != null) {
            System.out.print(" <- " + curr.data + " -> ");
            curr = curr.prev;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();

        // Insert elements at front and end
        insertEnd(list, "A");
        insertEnd(list, "B");
        insertFront(list, "C");
        insertEnd(list, "D");

        // Print in both directions
        printForward(list);
        printBackward(list);

        // Delete from front
        deleteFront(list);
        printForward(list);

        // Delete from end
        deleteEnd(list);
        printForward(list);
    }
}
