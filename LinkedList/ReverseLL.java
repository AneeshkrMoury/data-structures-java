public class ReverseLL{
    Node head ;
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //normal linked data insertation 
    void insertData(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node ptr = head;
        while(ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = new_node;
    }

    //normal removing of data in ll  at end side ;
    void removeData(){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        Node secondLast = head ;
        Node lastData = head.next;
        while(lastData.next != null){
            secondLast = lastData;
            lastData= lastData.next;
        }
        Node temp = lastData ;
        secondLast.next  =  null;
        temp = null;
    }

    // printing linked list 
    void printList(){
        if(head == null){
            System.out.println("Data list is not created yet");
            return;
        }
        Node ptr = head;
        while(ptr != null){
            System.out.print(ptr.data+"->");
            ptr = ptr.next;
        }
        System.out.println();
    }
    //method to reverse Linked-List
    public ReverseLL reverseListtt(ReverseLL list){
        if(head == null){
            System.out.println("list is not created yet");
            return list;   
        }
        if(head.next == null){
            System.out.println("list have only one value");
            //System.out.println(head.data+"->");
            return list;
        }
        Node current = head;
        Node prev = null;

        while(current !=null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return list;
    }

    //main class 
    public static void main(String[] args) {
        ReverseLL list = new ReverseLL();

        list.insertData(10);
        list.insertData(20);
        list.insertData(30);
        list.insertData(40);

        list.printList();
        list.reverseListtt(list);
        list.printList();
    }
}