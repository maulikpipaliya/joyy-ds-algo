class SinglyLinkedList {
    private int length = 0;

    SinglyLinkedList() {
        this.length = 0;
    }

    class ListNode {
        private int data;
        private ListNode next;

        public ListNode() {
        } // empty constructor

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public ListNode(int data, ListNode nxt) {
            this.data = data;
            this.next = nxt;
        }

        public int getData() {
            return this.data;
        }

        public void setData(int d) {
            this.data = d;
        }

        public ListNode getNext() {
            return this.next;
        }

        public ListNode setNext(ListNode nxt) {
            this.next = nxt;
            return this.next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this != null)
                sb.append("(" + this.data + ") -> ");

            if (this.next != null)
                sb.append(this.next.data);

            return sb.toString();
        }
    }

    ListNode head, tail;

    // Appends the specified element to the end of this list.
    public boolean add(int data) {
        System.out.println("[INFO]: Adding element "+data+" at index 0");
        if (head == null) {
            ListNode newNode = new ListNode(data);
            head = tail = newNode;
            head.next = null;
            length++;
            return true;
        } else {
            ListNode newNode = new ListNode(data);
            tail.next = newNode;
            tail = newNode;
            length++;
        }
        return false;
    }

    // Inserts the specified element at the beginning of this list. 
    public void addFirst(int data) {
        System.out.println("[INFO]: Adding element "+data+" at index 0");
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        length++;
    }
    
    // Appends the specified element to the end of this list.
    public void addLast(int data) {
        System.out.println("[INFO]: Adding element "+data+" at index " + this.length);
        ListNode newNode = new ListNode(data);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void add(int index, int data) {
        System.out.println("[INFO]: Adding at index " + index);
        //resetting the index
        if (index < 0) {   
            index = 0;
            System.out.println("[INFO]: Index has been reset to 0 as it can't be negative = " + index);
        }
        if (index > this.length) {
            index = this.length; 
            System.out.println("[INFO]: Given index > "+this.length+" (Length of list). It has been reset to " + index);
        }
        
        if (index == 0)
            addFirst(data);
        else if (index == this.length)
            addLast(data);
        else {
            ListNode current = head;
            ListNode prev = null;
            int counter = 0;
            while (current != null && counter++ < index ) {
                prev = current;
                current = current.next;
            }
            ListNode newNode = new ListNode(data);  
            prev.next = newNode;
            newNode.next = current;
            length++; 
        }
    }

    public ListNode removeFirst() {
        ListNode nodeToDelete = head;
        System.out.println("[INFO]: Removing at index 0 (first element), data " + nodeToDelete.getData());
        head = head.next;
        System.out.println("[INFO]: Removed the first element " + nodeToDelete.getData());
        System.out.println("[INFO]: After removing, " + this);
        return nodeToDelete;
    }
    
    public ListNode removeLast() {
        ListNode nodeToDelete = tail;
        System.out.println("[INFO]: Removing at index " + this.length + "(last element), data " + nodeToDelete.getData());
        
        ListNode current = head;
        ListNode prev = null;
        while (current != tail) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        tail = prev;
        System.out.println("[INFO]: Removed at index " + this.length + ", data " + nodeToDelete.getData());
        
        return nodeToDelete;
    }
    
    public ListNode remove(int index) {
        if (!(index < 0 || index > this.length)) {
            System.out.println("[INFO]: Removing at index " + index + ", data ");
            System.out.println(this);
            ListNode current = head;
            int counter = 0;
            ListNode prev = null;
            while (current != null && counter++ < index) {
                prev = current;
                current = current.next;
            }

            System.out.println(prev);
            System.out.println(current);
            prev.next = current.next;
        }


        
        return null;
    }

    // Traversing the Linked List

    // Display
    public void display() {
        ListNode current = head;
        System.out.println("[INFO]: Display the list");
        System.out.println("\t" + this);
        System.out.println("\tHead : " + head.data);
        System.out.println("\tTail : " + tail.data);
        while (current != null) {
            System.out.print("\t"+current);
            if (current == tail)
                System.out.print(current.next);
            System.out.println();
            current = current.next;
        }

    }

    @Override
    public String toString() {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        sb.append("List : [");
        while (current != null) {
            sb.append(current.data);
            if (current != tail) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    //TC : O(n), SC: O(1) 
    public int length() {
        ListNode current = head;
        int counter = 0;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

}



public class LinkedListImpl {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    public static void main(String[] args) {
        clearScreen();
        System.out.println("SINGLY LINKED LIST \n\n");
        
        SinglyLinkedList sLinkedList = new SinglyLinkedList();
        
        sLinkedList.add(15);
        sLinkedList.add(16);
        sLinkedList.add(17);
        sLinkedList.add(18);
        sLinkedList.addFirst(10);
        sLinkedList.addLast(90);
        System.out.println(sLinkedList);
        sLinkedList.add(8, 20);
        // sLinkedList.display();
        
        System.out.println(sLinkedList.removeFirst());
        System.out.println(sLinkedList.removeLast());
        System.out.println(sLinkedList.remove(2));
        System.out.println(sLinkedList);
        sLinkedList.display();

        

    }
}