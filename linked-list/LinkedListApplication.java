

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
                sb.append("{ CurrentListItem:  ");
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
            // System.out.println(counter);
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

    //Retrieves, but does not remove, the head (first element) of this list.
    public ListItem element() {
        return head;
    }

    //Returns the element at the specified position in this list.
    public int get(int index) {
        ListItem current = head;

        if (index < 0 || index > this.size()) {
            System.err.println("[ERROR] : Invalid index provided.");
            return Integer.MIN_VALUE;
        }
        int counter = 0;
        while (current != null && counter++ < index) {
            current = current.next;
        }

        return current.data;
    }


    //Returns the first element in this list.
    public ListItem getFirst()
    {
        return head;
    }

    //Returns the last element in this list.
    public ListItem getLast() {
        return tail;
    }

    //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public int indexOf(int data) {
        ListItem current = head;
        int counter = 0;
        while (current != null) {
            if (current.data == data) {
                return counter;
            }
            counter++;
            current = current.next;
        }
        return Integer.MIN_VALUE;
    }

    //Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public int lastIndexOf(int data) {
        ListItem current = head;
        int counter = 0, indexFound = Integer.MIN_VALUE;
        while (current != null) {
            if (current.data == data) {
                indexFound = counter;
            }
            counter++;
            current = current.next;
        }
        return indexFound;
        
    }


    //Adds the specified element as the tail (last element) of this list.
    public boolean offer(int data) {
        tail.setListItemData(data);
        return true;
    }

    //Inserts the specified element at the front of this list.
    public boolean offerFirst(int data) {
        addFirst(data);
        return true;
    }


    //Inserts the specified element at the end of this list.
    public boolean offerLast(int data) {
        addLast(data);
        return true;
    }

    //Retrieves, but does not remove, the head (first element) of this list.
    public ListItem peek() {
        return head;
    }


    //Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
    public ListItem peekFirst() {
        if (head != null) {
            return head;
        }
        return null;
    }
    
    //Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
    public ListItem peekLast() {
        if (tail != null) {
            return tail;
        }
        return null;
    }

    //Retrieves and removes the head (first element) of this list.
    public ListItem remove() {
        ListItem oldHead = head;
        head = head.next;
        if (this.size() == 1) {
            tail = head;
        }
        return oldHead;
    }
    
    public ListItem remove(int index) {
        ListItem current = head;
        int indexCopy = 0;
        System.out.println(this);
        ListItem prev = null;
        System.out.println("[INFO] : Removing item at index " + index + ". Data is " + this.get(index));
        if (index <= 0) {
            index = 0;
            System.out.println("[INFO] : Removing first item. Data is " + this.get(index));
            return remove();
        }
        else {
            while (current != null && indexCopy++ < index) {
                prev = current;
                current = current.next;
            }
        
            prev.setNextListItem(current.next);

            //if that is the last element, reset the tail
            if (index == this.size()) {
                System.out.println("[INFO] : Resetting tail as last removed value was at the end of the list.");
                tail = prev;
            }

            return current;
        }
        // return null;
    }
    //Retrieves and removes the head (first element) of this list.
    public ListItem poll() {
        return remove();
    }
    
    //Retrieves and removes the first element of this list, or returns null if this list is empty.
    public ListItem pollFirst() {
        if (this.size() <= 0) {
            return remove();
        }
        return null;
    }

    //Retrieves and removes the last element of this list, or returns null if this list is empty.
    public ListItem pollLast() {
        System.out.println("[INFO] : Retrieving and removing the last element of this list");
        if (this.size() != 0) {
            return remove(this.size() - 1);
        }
        return null;
    }
    
    //Pops an element from the stack represented by this list.
    public ListItem pop() {
        return pollLast();
    }


    //Pushes an element onto the stack represented by this list.
    public void push(int data) {
        add(data);
    }

    //Removes the first occurrence of the specified element from this list, if it is present.
    public void removeListItemsWithData(int data) {
        System.out.println("[INFO] : Removing all nodes having data " + data);
        ListItem current = head;
        int counter = 0;
        while (current != null) {
            if (current.data == data) {
                //because one element will get removed after this function run.
                this.remove(counter--);
            }
            counter++;
            current = current.next;
        }
    }

    //Removes and returns the first element from this list.
    public ListItem removeFirst() {
        if (this.size() != 0)
             return remove(0);
        return null;
    }
    
    //Removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
    public ListItem removeFirstOccurrence(int data) {
        return this.remove(indexOf(data));
    }

    //Removes and returns the last element from this list.
    public ListItem removeLast() {
        return this.remove(this.size()-1);
    }

    //Removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
    public ListItem removeLastOccurrence(int data) {
        return this.remove(this.lastIndexOf(data));
    }

    //Returns an array containing all of the elements in this list in proper sequence (from first to last element).
    public int[] toArray(LinkedList list) {
        int[] listArray = new int[this.size()];
        for (int i = 0; i < listArray.length; i++) {
            listArray[i] = this.get(i);
        }
        return listArray;
    }

    //Replaces the element at the specified position in this list with the specified element.
    public void set(int index,int data){

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
        sb.append("[INFO] : LIST("+ this.size() +") NOW - [");

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
        list.add(4);
        list.add(25);
        list.add(27);
        list.add(29);
        list.add(30);
        list.add(12, 45);

        int[] arrayData = { 5, 6, 7, 8, 9 };
        int[] sameValues = { 4, 4, 4 };
        list.addAll(4, sameValues);
        list.addAll(2, arrayData);
        list.addFirst(87);
        list.addLast(95);
        // list.clear();
        // System.out.println(list.clone());
        // System.out.println(list.contains(7));
        // System.out.println(list.element());
        // System.out.println(list.get(3));

        System.out.println(list);
        System.out.println("------------------");
        
        
        System.out.println(list.indexOf(25));
        System.out.println(list.lastIndexOf(4));
        System.out.println(list.offer(99));
        System.out.println(list);

        System.out.println("------------------");
        System.out.println(list.remove());
        
        System.out.println("------------------");
        System.out.println(list.remove(12));
        // System.out.println(list.poll());
        System.out.println(list.pollLast());
        // list.removeListItemsWithData(4);
        list.removeFirst();
        list.add(3, 4);
        list.removeFirstOccurrence(4);
        list.removeLast();
        list.removeLastOccurrence(4);

        int[] arr = list.toArray(list);

        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(arr);
        // System.out.println(list);

    }
}