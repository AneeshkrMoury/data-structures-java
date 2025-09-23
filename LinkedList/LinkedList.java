/**
 * LinkedList.java
 * ----------------
 * A simple menu-driven Java program to demonstrate
 * operations on a singly linked list:
 *  - Insert at end, head, or a given position
 *  - Delete from end, head, or a given position
 *  - Display all nodes
 *
 * Author : Aneesh Kumar Mourya
 * Date   : 09/20/2025
 */

import java.util.Scanner;

public class LinkedList{
    Node head; // head (first node) of the linked list
    
    /** Node class represents each element of the list */
    public static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    /**
     * Insert a new node at the END of the list.
     * Time Complexity: O(n)
     */
    public static LinkedList insertAtTail(LinkedList list , int data){
        Node new_node = new Node(data);
        if(list.head == null){ // if list is empty
            list.head = new_node;
        }
        else{
            Node ptr;
            for(ptr=list.head; ptr.next != null; ptr=ptr.next); // traverse to the last node
            ptr.next = new_node;
        }
        System.out.println(new_node.data);
        return list;
    }
    
    /**
     * Insert a new node at the HEAD of the list.
     * Time Complexity: O(1)
     */
    public static LinkedList insertAtHead(LinkedList list, int data){
        Node new_node = new Node(data);
        if(list.head == null){
            list.head = new_node;
        }else{
            new_node.next = list.head;
            list.head = new_node;
        }
        System.out.println(new_node.data);
        return list;
    }

    /**
     * Insert a new node at a specific POSITION (1-based index).
     * If position is larger than size, it appends at the end.
     * Time Complexity: O(n)
     */
    public static LinkedList insertAtRandom(LinkedList list, int data, int position){
        Node new_node = new Node(data);
        if(list.head == null || position <= 1){
            list.head = new_node;
        }else{
            Node ptr;
            int i;
            // move to node just before desired position
            for(ptr=list.head, i=1; i<position-1; i++){
                ptr=ptr.next;
            }
                new_node.next = ptr.next;
                ptr.next = new_node;
        }
        System.out.println(new_node.data);
        return list;
    }

    /** Delete the LAST node of the list. */
    public static LinkedList delete(LinkedList list){
        if(list.head == null){
            System.out.println("list is empty");
        }else{
            Node ptr;
            for(ptr=list.head; ptr.next.next != null; ptr = ptr.next);// find second-last node
                Node temp = ptr.next;
                ptr.next = null;
                temp = null;   
        }
        return list;
    }

    /** Delete the FIRST node of the list. */
    public static LinkedList deleteAtHead(LinkedList list){
        if(list.head == null){
            System.out.println("list is empty");
        }else{
            Node temp = list.head;
            list.head = list.head.next;
            temp = null;
        }
        return list;
    }
    /**
     * Delete a node at a given POSITION (1-based index).
     */
    public static LinkedList deleteAtRandom(LinkedList list, int position){
        if(list.head == null){
            System.out.println("list is empty");
        }else{
            Node ptr;
            int i;
            for(ptr=list.head, i=1; i<position-1; i++){
                ptr=ptr.next;
            }
                Node temp = ptr.next;
                ptr.next = temp.next;
                temp = null;
            
        }
        return list;
    }

    /** Print all elements of the list. */
    public static void printList(LinkedList list){
        if(list.head == null){
            System.out.println("list is empty");
            return;
        }
        Node ptr;
        for(ptr=list.head; ptr!=null; ptr=ptr.next){
            System.out.print(ptr.data+" ");
        }
        System.out.println();
    }
    
    /** Main menu for user interaction. */
    public static void main(String[] args) {
    LinkedList list = new LinkedList();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your choice to perform on linked list");
    while(true){
        System.out.println("1 add data to list ");
        System.out.println("2 View the list ");
        System.out.println("3 remove list data");
        System.out.println("4 exit from the list operation");
        System.out.println("Enter your choice");

        int choice =sc.nextInt();
            switch(choice){
            case 1:
                System.out.println("Choose where u want to add the data");
                System.out.println("1 for normal flow of addition");
                System.out.println("2 for addition at head");
                System.out.println("3 for addition at random positon");
                System.out.print("enter your choice of addition: ");
                int choiceAdd = sc.nextInt();
                if(choiceAdd == 1){
                    System.out.print("enter data to add in list : ");
                    int data = sc.nextInt();
                    insertAtTail(list, data);
                }else if (choiceAdd == 2){
                    System.out.print("enter data to add in list : ");
                    int data = sc.nextInt();
                    insertAtHead(list, data);
                }else{
                    System.out.println("enter location: ");
                    int pos = sc.nextInt();
                    System.out.print("enter data to add in list : ");
                    int data = sc.nextInt();
                    insertAtRandom(list, data, pos);
                }
                break;

            case 2:
                printList(list);
                break;

            case 3:
                System.out.println("Choose where u want to delete the data");
                System.out.println("1 for normal flow of removing data");
                System.out.println("2 for removing at head");
                System.out.println("3 for removing at random positon");
                System.out.print("enter your choice for removing data: ");
                int choiceRemove = sc.nextInt();
                if(choiceRemove == 1){
                    delete(list);
                }else if (choiceRemove == 2){
                    deleteAtHead(list);
                }else{
                    System.out.println("enter location: ");
                    int pos = sc.nextInt();
                    deleteAtRandom(list, pos);
                }
                break;

            case 4:
                sc.close();
                System.exit(0);
                break;

            default:
                System.out.println("please enter a valid choice");
            }

        }
    }
}
/*
================= Sample Output =================

\Users\HP\AppData\Roaming\Code\User\workspaceStorage\
4cef86be6647b5f21577b243f2e5ec4d\redhat.java\
jdt_ws\data-structures-java_6a20e96a\bin' 'LinkedList'

Enter your choice to perform on linked list
1 add data to list 
2 View the list 
3 remove list data
4 exit from the list operation
Enter your choice
1
Choose where u want to add the data
1 for normal flow of addition
2 for addition at head
3 for addition at random positon
enter your choice of addition: 1
enter data to add in list : 3
3
1 add data to list
2 View the list
3 remove list data
4 exit from the list operation
Enter your choice
1
Choose where u want to add the data
1 for normal flow of addition
2 for addition at head
3 for addition at random positon
enter your choice of addition: 1
enter data to add in list : 5
5
1 add data to list
2 View the list
3 remove list data
4 exit from the list operation
Enter your choice
2
3 5 
1 add data to list
2 View the list
3 remove list data
4 exit from the list operation
Enter your choice
3
Choose where u want to delete the data
1 for normal flow of removing data
2 for removing at head
3 for removing at random positon
enter your choice for removing data: 1
1 add data to list 
2 View the list
3 remove list data
4 exit from the list operation
Enter your choice
2
3 
1 add data to list
2 View the list
3 remove list data
4 exit from the list operation
Enter your choice
4

==================================================
*/
