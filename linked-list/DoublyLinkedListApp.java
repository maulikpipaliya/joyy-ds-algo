class DoublyLinkedList {
    class ListItem {
        private int data;
        private ListItem next;
        private ListItem prev;

        public ListItem(int data) {
            this.data = data;
            this.next = this.prev = null;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();

            try {
                sb.append("{ PrevItem:  ");
                if(!(this.prev == null))    
                    sb.append(this.prev.data);
                else{
                    sb.append("null");
                }
                sb.append(", ListItem:  ");
                sb.append(this.data);
                // sb.append("\t");
                sb.append(", NextListItem : ");

                if(!(this.next == null))
                    sb.append(this.next.data);
                else
                    sb.append("null");
                sb.append("}");
            } catch (Exception e) {
                sb.append(e.getMessage());
            }
            return sb.toString(); 
        }
    }

    ListItem head = null, tail = null;

    public void add(int data) {
        ListItem newListItem = new ListItem(data);
        if (head == null) {
            head = tail = newListItem;
        } else {
            tail.next = newListItem;
            newListItem.prev = tail;
            tail = newListItem;
        }
    }

    public void add(int index, int data) {
        if (index <= 0) {   
            System.out.println("[WARN] : Given index " + index + " is less than 0. Thus setting it to " + 0);
            index = 0;
        }
        if (index >= this.size()) {
            System.out.println("[WARN] : Given index " + index + " is greater than the size of the list. Thus setting it to " + this.size());
            index = this.size();
        }

        System.out.println("[INFO] : Inserting " + data + " on index " + index);
        ListItem newListItem = new ListItem(data);
        //if the list is empty
        if (this.size() == 0 && head == null) {
            head = tail = newListItem;
        } else {
            
            ListItem current = head;
            int indexCopy = 0;
            ListItem tempPrevious = null;
            while (current != null && indexCopy++ < index) {
                tempPrevious = current;
                current = current.next;
            }
            
            System.out.println("[INFO] : Currently, data on index " + index + " is: " + current);
            
            if (index == this.size()) {
                System.out
                        .println("[INFO] : Currently, data on previous index " + (index - 1) + " is: " + tempPrevious);
                        tempPrevious.next = newListItem;
                        newListItem.prev = tempPrevious;
                        tail = tempPrevious;
            } else if (index == 0) {
                newListItem.next = head;
                head.prev = newListItem;
                head = newListItem;
            } else {
                current.prev.next = newListItem;
                newListItem.next = current;
                newListItem.prev = current.prev;
                current.prev = newListItem;
            }
        }
        
    }
    
    public void remove(int index) {
        if (index <= 0) {   
            System.out.println("[WARN] : Given index " + index + " is less than 0. Thus setting it to " + 0);
            index = 0;
        }
        if (index >= this.size()) {
            System.out.println("[WARN] : Given index " + index
            + " is greater than the size of the list. Thus setting it to " + (this.size() - 1));
            index = this.size() - 1;
        }
        
        System.out.println("[INFO] : Removing item on index " + index);
        
        
        if (index == 0) {
            head = head.next;
            head.prev = null;
        }
        else if (index == this.size() - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            int indexCopy = 0;
            ListItem current = head;
            while (current != null && indexCopy++ < index) {
                current = current.next;
            }
            System.out.println("[INFO] : This item is being removed. " + current );

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        
    }
    



    public int size() {
        ListItem current = head;
        int counter = 0;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }
    
    public void printDetailedLinkedList() {
        ListItem current = head;
        while(current != null){
            System.out.println(current);
            current = current.next;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[INFO]: LIST("+ this.size() +") NOW - [");

        ListItem current = head;
        while(current != null){
            sb.append(current.data);
            current = current.next;
            if(current != null)
                sb.append("->");
        }
        sb.append("]");
        
        return sb.toString();
    }
    
}

/**
 * InnerDoublyLinkedList
 */
public class DoublyLinkedListApp {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("Doubly LinkedList Application");

        DoublyLinkedList list = new DoublyLinkedList();
        list.add(23);
        list.add(4);
        list.add(25);
        list.add(27);
        list.add(29);
        list.add(30);
        System.out.println(list);
        list.remove(2);
        System.out.println("\n\n\n");
        System.out.println(list);
        System.out.println("\n\n\n");
        list.printDetailedLinkedList();
    }
}
    
