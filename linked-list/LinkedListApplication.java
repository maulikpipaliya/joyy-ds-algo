

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

    //Appends the specified element to the end of this list.
    public boolean add(int data) {
        if (head == null) {
            head = tail = new ListItem(data);
            tail.next = null;
            System.out.println("[INFO] : INSERT SUCCESSFUL. Data(" + data + ") inserted as head and tail");
            return true;
        } else {
            ListItem current = head;
            while (current.next != null) {
                current = current.next;
            }
            tail = current.setNextListItemData(data);
            System.out.println("[INFO] : INSERT SUCCESSFUL. Data(" + data + ") inserted in the list at the end");
            return true;
        }
    }
    
    //Inserts the specified element at the specified position in this list.

    public boolean add(int index, int data) {
        System.out.println(this);

        if (index < 0) {
            System.err.println("[WARN] : Index less than 0. Setting it to 0.");
            index = 0;
        } else if (index > this.size()) {
            System.err.println("[WARN] : Index more than the size of list. Setting it to " + this.size());
            index = this.size();
        }

        System.out.println("[INFO] : INSERTING At index " + index + ", Data(" + data + ")");
        ListItem current = head;
        int counter = 0;

        if (index == 0) {
            ListItem newListItem = new ListItem(data);
            newListItem.setNextListItem(current);
            head = newListItem;
        } else {

            while (current != null && ++counter < index) {
                current = current.next;
            }
            System.out.println(counter);
            ListItem oldNext = current.getNextListItem();
            ListItem newListItem = current.setNextListItemData(data);
            newListItem.setNextListItem(oldNext);
            if (index == this.size() - 1) {
                tail = newListItem;
            }
        }

        return true;
    }

    
    //Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.

    public boolean addAll(int[] dataArray) {
        if (dataArray.length != 0) {
            for (int i : dataArray) {
                this.add(i);
            }
            return true;
        }
        return false;
    }

    //Inserts all of the elements in the specified collection into this list, starting at the specified position.
    public boolean addAll(int index, int[] dataArray) {
        int indexCopy = index;
        for (int i : dataArray) {
            add(indexCopy++, i);
        }
        return true;
    }

    //Inserts the specified element at the beginning of this list.

    public void addFirst(int data) {
        add(0, data);
    }

    //Appends the specified element to the end of this list.
    public void addLast(int data) {
        add(this.size(), data);
    }

    //Removes all of the elements from this list.
    public void clear() {
        System.err.println("[WARN] : The list will be cleared");
        head = tail = null;
        System.err.println("[INFO] : List is cleared. Size is now : " + this.size());
    }


    //Returns a shallow copy of this LinkedList.
    public LinkedList clone() {
        System.out.println("[INFO] : List is being cloned.");
        LinkedList newList = new LinkedList();
        ListItem current = head;
        while (current != null) {
            newList.add(current.data);
            current = current.next;
        }
        System.out.println("[INFO] : List is cloned.");
        return newList;
    }


    //Returns true if this list contains the specified element.
    public boolean contains(int data) {
        boolean contains = false;
        ListItem current = head;
        while (current != null) {
            if (current.data == data) {
                contains = true;
                break;
            }
            current = current.next;
        }
        return contains;
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
        list.add(12, 45);

        int[] arrayData = { 5, 6, 7, 8, 9 };
        list.addAll(2, arrayData);
        list.addFirst(87);
        list.addLast(95);
        // list.clear();
        System.out.println(list.clone());
        System.out.println(list.contains(7));
        System.out.println(list);

    }
}