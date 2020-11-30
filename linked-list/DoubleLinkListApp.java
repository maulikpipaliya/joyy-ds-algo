class DoubleLinkList {

        
    private int nElems = 0;
    ListItem head, tail;

    class ListItem{
        int data;
        ListItem next;
        ListItem prev;
        
        ListItem(int data){
            this.data = data;
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
    
    public void insert(int index,  int data){

        System.out.println("------------");
        
        ListItem newListItem = new ListItem(data);
        if(head == null){
            head = tail = newListItem;
            System.out.println("head: " + head);
        }   
        else{
            ListItem current = head;
            
            tail.next = newListItem;
            newListItem.prev = tail;
            tail = newListItem;

            while(current!=null){
                System.out.println(current);
                current = current.next;
            }
            System.out.println(current);


        }
        nElems++;
        // System.out.println("current is :"  + current);
    }

    public void insertAtIndex(int index, int data){
        //4 element, index = 3 --------- 3 > 4
        // System.out.println(nElems);
        if(index < 0 || index > (nElems)){
            System.err.println("[ERROR]: Wrong Index provided");
        }
        else{
            System.out.println("[INFO]: Inserting "+ data + " at index " + index);

            ListItem newListItem = new ListItem(data);
            
            int indexCopy = 0;
            
            ListItem current = head;
  
            while(current != null){
                if(indexCopy++ == index){
                    break;
                }
                current = current.next; 
            } 
            
            // System.out.println("@"+current);
            // System.out.println("Index : " + (indexCopy) );
            // current = head;
            // System.out.println(current);
            if(head == null && tail == null){
                System.out.println("i=" + indexCopy);
                head = tail = newListItem;
                nElems++;
                System.out.println("[INFO]: New ListItem added as head :" + head);
                // System.out.println(this);
            }
            else{
                // current = current.next;
                System.out.println("i=" + indexCopy);
                current = getListItemHavingIndex(indexCopy-1);
                /*
                System.out.println("------" + this);
                System.out.println("currentis : " + current);
                System.out.println("to add : " + newListItem);
                // System.out.println();
                ListItem prevNode = current.prev;
                //p11n     p22n
                if(current == head){
                    current.next = newListItem;
                    newListItem.prev = head;
                    // head.prev = newListItem;
                    head = newListItem;
                    tail = tail.next;
                }
                else{
                    prevNode.next = newListItem;
                    newListItem.prev = prevNode;
                    newListItem.next = current;
                    current.prev = newListItem;
                }
/*
                if(current.next == null){
                    tail = newListItem;
                }
                else{
                    newListItem.next = current.next;
                    current.next.prev = newListItem;
                }
                current.next = newListItem;
                newListItem.prev = current;
*/
                
                current = getListItemHavingIndex(indexCopy-1);
                System.out.println("current is:" + current);

                if(current == head){
                    System.out.println("HEAD NOW");
                    current.next = newListItem;
                    newListItem.prev = head;
                    head = newListItem;
                }
                            
                /*tail.next = newListItem;
                newListItem.prev = tail;
                tail = newListItem;
/*

                if(current == head){
                    current.next = newListItem;
                    newListItem.prev = head;
                    // head.prev = newListItem;
                    head = newListItem;
                    tail = tail.next;
                }
                else{
                    prevNode.next = newListItem;
                    newListItem.prev = prevNode;
                    newListItem.next = current;
                    current.prev = newListItem;
                }
               */
                /*
                if(current == tail){
                    current.next = newListItem;
                    newListItem.prev = current;
                    tail = newListItem;
                }
                else{   
                    current.next.prev = newListItem;
                    newListItem.next = current.next;
                    current.next = newListItem;
                    newListItem.prev = current;
                }*/
                nElems++;
                    
                // System.out.println("[INFO]: Inserted " + data + " at index " + index);
            }
            System.out.println(this);
        }
        
    }

    public int getIndexHavingData(int data){
        ListItem current = head;
        int i = 0;

        System.out.println(this);
        while(current != null && current.data != data){
            i++;
            System.out.println(current);
            current = current.next; 
            if(current.data == data) return i;
        }

        System.err.println("[ERROR]: No Index found, returning garbage value");
        return Integer.MIN_VALUE;
    }
    
    public ListItem getListItemHavingIndex(int index){
        int data = 0;
        int i = 0;
        
        int mid = nElems / 2;
        
        if(index > mid){
            //end to mid
            System.out.println("Lol");
            ListItem current = tail;

            int end = nElems - 1;
            while(current != null && end != index){
                System.out.println(current);
                if(end == index) return current;
                end--;
                current = current.prev; 
            }
            return current;
            
        }
        else{
            //start to mid
            
            ListItem current = head;
            while(current != null && i != index){
                i++;
                current = current.next; 
                if(i == index) return current;
            }
            return current;
        }

    }

    public int getDataHavingIndex(int index){
        return getListItemHavingIndex(index).data;
    }

    



    public void printList(){
        ListItem current = head;
            
        while(current != null){
            System.out.println(current);
            current = current.next; 
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
}

public class DoubleLinkListApp{
    
    public static void main(String[] args) {
        DoubleLinkList dll = new DoubleLinkList();
        
        dll.insertAtIndex(0,11);
        dll.insertAtIndex(1,22);
        dll.insertAtIndex(2,33);
        dll.insertAtIndex(3,44);
        
        System.out.println(dll);
        System.out.println("--------");
        // dll.insertAtIndex(2, 78);
        // dll.insertAtIndex(0, 99);
        
        // System.out.println(dll);
        
        // System.out.println(dll.getIndexHavingData(33));
        // System.out.println(dll.getDataHavingIndex(1));
        System.out.println(dll.getListItemHavingIndex(0));

        // System.out.println(dll);
        // dll.printList();
    }
}


