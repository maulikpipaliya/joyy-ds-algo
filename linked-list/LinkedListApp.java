import java.util.ArrayList;
import java.util.List;


public class LinkedListApp {
    
    class ListItem {
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

    //All other insert functions
    public void insertAtFront(int data){
        System.out.println("[INFO]: Inserting at front ");
        this.insertAtIndex(0, data);
    }

    public void insertAtLast(int data){
        System.out.println("[INFO]: Inserting at last ");
        this.insertAtIndex(nElems, data);
    }

    public void insertBeforeListItem(int index_data, int data){
        int i = this.getIndex(index_data);
        this.insertAtIndex(i, data);
    }
    
    public void insertAfterListItem(int index_data, int data){
        int i = this.getIndex(index_data);
        this.insertAtIndex(i + 1, data);
    }

    public void insertBeforeIndex(int index, int data){
        System.out.println("[INFO]: Inserting before index " + index);
        this.insertAtIndex(index, data);
    }
    
    public void insertAfterIndex(int index, int data){
        System.out.println("[INFO]: Inserting after index " + index);
        this.insertAtIndex(index + 1 , data);
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
            if(current == tail){
                tail = prev;
            }
            System.out.println("[INFO]: Removed this item -" + current);
            
            nElems--;
            // System.out.println("[INFO]: Removing this item -" + current);
            System.out.println(this);
            
        }
    }
    
    public void removeFromFront(){
        System.err.println("[INFO]: Removing item from front");
        this.removeAtIndex(0);
    }
    public void removeFromLast(){
        System.err.println("[INFO]: Removing item from last");
        this.removeAtIndex(nElems - 1);
    }
    public void removeBeforeListItem(int index_data){
        System.err.println("[INFO]: Removing an item before the value " +  index_data);
        int i = this.getIndex(index_data);
        this.removeAtIndex(i - 1);
    }
    public void removeAfterListItem(int index_data){
        System.err.println("[INFO]: Removing an item after the value " +  index_data);
        int i = this.getIndex(index_data);
        this.removeAtIndex(i + 1);
    }
    public void removeBeforeIndex(int index){
        System.out.println("[INFO]: Removing an item before an index " + index);
        this.removeAtIndex(index - 1);
    }
    public void removeAfterIndex(int index){
        System.out.println("[INFO]: Removing an item after an index " + index);
        this.removeAtIndex(index + 1);
    }

    public int getIndex(int data){
        ListItem current = head;
        ListItem prev = null;
        int indexCopy = 0;
        boolean isFound = false;
        while(current != null && current.data != data){
            if (current.data == data)  isFound = true;
            prev = current;
            current = current.next;
            indexCopy++;
        }
        if(isFound) return indexCopy;
        else{
            System.err.println("[ERROR]: No index with value " + data + " could be found");
            return Integer.MIN_VALUE;
        }
    }

    public LinkedListApp getAllIndices(int data){
        LinkedListApp indices = new LinkedListApp();
        ListItem current = head;
        ListItem prev = null;
        
        int iter = 0;

        while(current != null ){
            prev = current;
            if(current.data == data){
                indices.insertAtLast(iter);
            }
            iter++;
            current = current.next;
        }
        return indices;          
    } 

    public int getDataOnIndex(int index){
        ListItem current = head;
        int i = 0;
        while(current!=null){
            if(i == index) return current.data;
            i++;
            current = current.next;
        }
        System.err.println("[ERROR]: No index found, returning garbage value");
        return Integer.MIN_VALUE;
    }

    public void removeWithData(int data){
        int i = this.getIndex(data);
        System.out.println("[INFO]: Removing first instance of ListItem when "+ data + " is found (on Index "+ i+  ")");
        this.removeAtIndex(i);
        System.out.println("[INFO]: Removed first instance of ListItem when "+ data + " was found");
    }
    
    public int getSize(){
        return this.nElems;
    }
    
    public void removeWithDataAll(int data){
        LinkedListApp allIndices = this.getAllIndices(data);
        
        System.out.println("[INFO]: Found indices" + allIndices);

        System.out.println(allIndices.getIndex(0));
        
        for (int j = allIndices.getSize() - 1; j >= 0  ; j--) {
            this.removeAtIndex(allIndices.getDataOnIndex(j));
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


    public LinkedListApp (){

    }



   
    public static void main(String[] args) {
        LinkedListApp list = new LinkedListApp();
        
        list.insert(34);
        list.insert(35);
        list.insert(36);
        list.insert(37);
        list.insert(35);
        list.insert(38);
        list.insert(35);

        // list.printList();

        System.out.println();
        // list.insertAtIndex(1, 43);
        // list.removeAtIndex(0);
        list.removeWithDataAll(35); // deletes the first instance
        // list.insertAtFront(85);
        // list.insertAtLast(87);
        System.out.println(list.getIndex(40));
        
        // list.insertBeforeListItem(34, 99); //before 1st instance found
        // list.insertAfterListItem(34, 75);

        // list.insertBeforeIndex(4, 11);
        
        // list.insertAfterIndex(4,22);

        // list.removeFromFront();
        // list.removeFromLast();

        // list.removeBeforeListItem(75);
        // list.removeAfterListItem(22);
        
        // list.insertAtLast(22);
        // System.out.println(list.getIndex(22));
        
        // // System.out.println(list);

        // list.removeBeforeIndex(2);

        // System.out.println(list.getDataOnIndex(10));

        // list.removeWithDataAll(22);
    }
}
