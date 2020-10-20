
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

    public void enqueue(long data){
        if(!isQueueFull()) {
            arr[++rear] = data;
            System.out.println("[INFO]: Enqueued " + data);
            return;
        }
        System.out.println("[INFO]: Enqueuing " + data);
        System.err.println("[ERROR]: Queue capacity("+ capacity +") full. Cannot enqueue the element " + data);
    }

    //Physical Queue
    public void dequeue(){
        // System.out.println(rear);
        long dequeuedElement = arr[0];
        if(!isQueueEmpty()){
            for (int i = front; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            System.out.println("\n[INFO]: Dequeud " + dequeuedElement);
            displayQueue();
            return;
        }
        System.out.println("\n[INFO]: Dequeuing");
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
        
        System.out.println("\nCURRENT QUEUE VIEW");
        System.out.println("------------------");
        
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
        int qCapacity = 10;
        Queue queue = new Queue(qCapacity);

        long[] qData = {5,6,7,8,9,2,5,7,1,4};

        for (int i = 0; i < qData.length; i++) {
            queue.enqueue(qData[i]);
        }

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
