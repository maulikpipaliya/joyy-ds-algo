

/**
 * LinkedList
 */
class LinkedList {
   
    class ListItem {
        private int data;
        private ListItem next;

        public ListItem(int data) {
            this.data = data;
        }

        public void setListItemData(int data) {
            this.data = data;
        }

        public int getListItemData() {
            return this.data;
        }

        public ListItem getListItem() {
            return this;
        }

        public void setNextListItem(ListItem next) {
            this.next = next;
        }

        public ListItem setNextListItemData(int data) {
            ListItem item = new ListItem(data);
            this.next = item;
            this.next.data = data;
            return this.next;
        }

        public ListItem getNextListItem() {
            return this.next;
        }

        public int getNextListItemData() {
            return this.next.data;
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
    
    private ListItem head = null, tail = null;

    public boolean add(int data) {
        if (head == null) {
            head = tail = new ListItem(data);
            tail.next = null;
            System.out.println("[INFO] : INSERT SUCCESSFUL. Data("+ data+") inserted as head and tail");
            return true;
        } else {
            ListItem current = head;
            while (current.next != null) {
                current = current.next;
            }
            tail = current.setNextListItemData(data);
            System.out.println("[INFO] : INSERT SUCCESSFUL. Data("+ data+") inserted in the list at the end");
            return true;
        }
    }
    
    public boolean add(int index, int data) {
        if (index < 0) {
            System.err.println("[WARN] : Index less than 0. Setting it to 0.");
            index = 0;
        }
        else if (index > this.size()) {
            System.err.println("[WARN] : Index more than the size of list. Setting it to " + this.size());
            index = this.size();
        }
        
        System.out.println("[INFO] : INSERTING At index "+index+", Data("+ data+")");
        ListItem current = head;
        int counter = 0;
        
        while (current != null && ++counter < index) {
            current = current.next;
        }
        
        ListItem oldNext = current.getNextListItem();
        ListItem newListItem = current.setNextListItemData(data);
        newListItem.setNextListItem(oldNext);
        

        // System.out.println(current);
        // System.out.println(counter);
        return true;
    }

    public int size() {
        ListItem current = head;
        int nElems = 0;
        while (current != null) {
            nElems++;
            current = current.next;
        }
        return nElems;
    }

    public void displayList() {
        ListItem current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        // current.next = current.setNextListItemData(data);
        // return true;
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

public class LinkedListApplication {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("LinkedList Application");

        LinkedList list = new LinkedList();
        list.add(23);
        list.add(25);
        list.add(27);
        list.add(29);
        list.add(30);
        list.add(2, 45);        
        System.out.println(list);

    }
}