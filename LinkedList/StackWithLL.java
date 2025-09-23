/**
 * StsackWithLL.java
 * ------------------
 * Simple implementation of a Stack using a singly linked list in Java.
 * Supports push, pop, and peek operations.
 *
 * Author: Your Name
 * Date: YYYY-MM-DD
 **/


public class StackWithLL{
    Node head;
    static class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    /**
    * Push a new element onto the top of the stack.
    * Time Complexity: O(1)
    **/
    public static StackWithLL push(StackWithLL list, String data){
        Node new_node = new Node(data);
        if(list.head == null){
            list.head = new_node;
        }else{
           new_node.next = list.head;
           list.head = new_node;
        }
        return list;
    }

    public static StackWithLL pop(StackWithLL list){
        if(list.head == null){
            System.out.println("list is empty");
        }else{
            Node temp = list.head;
            // Move head pointer to next node (pop operation)
            list.head = temp.next;
            temp = null;
        }
        return list;
    }

    public static void peek(StackWithLL list){
        if(list.head == null){
            System.out.println("stack is empty ");
        }else{
            Node ptr = list.head;
            while(ptr != null){
                System.out.print(ptr.data+"->");
                ptr =ptr.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StackWithLL lsit = new StackWithLL();
        
        push(lsit,"I");
        push(lsit,"V");
        push(lsit,"A");
        push(lsit,"R");
        peek(lsit);
        pop(lsit);
        peek(lsit);
    }
}

/**output will look like
 * R->A->V->I->
 * A->V->I->
**/
