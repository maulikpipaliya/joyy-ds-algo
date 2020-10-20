
public class Queue {

    private long[] arr = null;
    int front = 0, rear = -1;
    int capacity = 5;

    public Queue(){
        this.arr = new long[this.capacity];
    }

    public Queue(int capacity){
        this.capacity = capacity;
        this.arr = new long[capacity];
    }

    public void enqueue(int data){
        System.out.println("[INFO]: Enqueuing " + data);
        if(!isQueueFull()) {
            arr[++rear] = data;
            System.out.println("[SUCCESS]: Enqueued " + data);
            return;
        }
        System.err.println("[ERROR]: Queue capacity("+ capacity +") full. Cannot enqueue the element " + data);
    }

    //Physical Queue
    public void dequeue(){
        // System.out.println(rear);
        System.out.println("\n[INFO]: Dequeuing");
        long dequeuedElement = arr[0];
        if(!isQueueEmpty()){
            for (int i = front; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            System.out.println("[INFO]: Dequeud " + dequeuedElement);
            displayQueue();
            return;
        }
        System.err.println("[ERROR]: Queue is empty. Cannot dequeue.");

    }

    //Traditional Queue
    public void dequeueTraditional(){
        front++;
        displayQueue();
    }

    public boolean isQueueFull(){
        return (rear + 1 == capacity);
    }

    public boolean isQueueEmpty(){
        return (rear == -1);
    }

    public void displayQueue(){
        System.out.println("----------------------------------------");
        System.out.println("CURRENT QUEUE VIEW");
        
        System.out.println("----------------------------------------");
        
        if(!isQueueEmpty()){
            System.out.print("FRONT <   ");
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            
            System.out.println("  < REAR");
        }
        else{
            System.err.println("[INFO] : Queue is empty. Nothing to display :(");
        }

    }

    public static void main(String[] args) {
         Queue queue = new Queue();

         queue.enqueue(5);
         queue.enqueue(6);
         queue.enqueue(7);
         queue.enqueue(8);
         queue.enqueue(9);
         queue.enqueue(2);
         queue.displayQueue();
         System.out.println();
         queue.dequeue();
         queue.dequeue();
         queue.dequeue();
         queue.dequeue();
         queue.dequeue();
         queue.dequeue();
    }
}
