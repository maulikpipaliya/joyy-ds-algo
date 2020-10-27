public class LinkedListApp {
    
    class ListItem{
        private int data;
        private ListItem next;

        public ListItem(int data){
            this.data = data;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();

            try {
                sb.append("{ ListItem:  ");
                sb.append(this.data);
                // sb.append("\t");
                sb.append(", NextListItem : ");
                sb.append(this.next.data);
                sb.append("}");
            } catch (Exception e) {
                sb.append(e.getMessage());
            }
            return sb.toString(); 
        }
    }

    ListItem head, tail;

    int nElems = 0;

    public void insert(int data){
        ListItem newListItem =  new ListItem(data);
        if(head == null){
            head = tail = newListItem;
        }
        else{
            tail.next = newListItem;
            tail = newListItem;
        }
        nElems++;
        System.out.println("\n\n[INFO]: " + data + " added to the list");
        System.out.println(this);
    }

    public void insertAtIndex(int index, int data){
        
        // System.out.println(new ListItem(45));
        System.out.println("[INFO]: Inserting " + data + " on index " + index);

        if(index > nElems || index < 0){
            System.err.println("[ERROR]: Wrong Index provided");
        }
        else{
            ListItem current = head;
            ListItem prev = null;
            int indexCopy = 0;
            
            ListItem newListItem = new ListItem(data);
            
            while(current != null && indexCopy != index){
                prev = current;
                current = current.next;
                indexCopy++;
            }
            if(prev == null){
                newListItem.next = head;
                head = newListItem;
            }
            else{
                prev.next = newListItem;
                newListItem.next = current;
            }
            nElems++;
            System.out.println(this);
        }


    }
    
    public void removeAtIndex(int index){
        if(index > nElems || index < 0){
            System.err.println("[ERROR]: removeAtIndex("+index+") -  Wrong Index provided");
        }
        else{
            System.err.println("[INFO]: Removing item AtIndex("+index+")");
            ListItem current = head;
            ListItem prev = null;
            int indexCopy = 0;

            while(current != null && indexCopy != index){
                indexCopy++;
                prev = current;
                current = current.next;
            }

            System.out.println("[INFO]: Removing this item -" + current);
            //if index 0
            if(prev == null){ 
                head = head.next;
            }
            else{
                prev.next = current.next;
                current.next = null;
            }
            System.out.println("[INFO]: Removed this item -" + current);

            nElems--;
            // System.out.println("[INFO]: Removing this item -" + current);
            System.out.println(this);
            
        }
    }

    public void printList(){
        System.out.println();
        if(head == null){
            System.out.print("[INFO] List is empty.");
        }
        else{
            System.out.print("List is : ");
            ListItem current = head;
            while(current != null){
                System.out.print(current.data);
                current = current.next;
            if(current != null)
            System.out.print("->");
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[INFO]: LIST("+ nElems +") NOW - [");

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



    public static void main(String[] args) {
        LinkedListApp list = new LinkedListApp();
        
        list.insert(34);
        list.insert(35);
        list.insert(36);
        list.insert(37);
        list.insert(38);

        // list.printList();

        System.out.println();
        // list.insertAtIndex(1, 43);
        list.removeAtIndex(0);
        

        // System.out.println(list);
    }
}
