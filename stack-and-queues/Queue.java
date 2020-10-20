
public class Queue {

    private long[] queueArray = null;
    int front, rear;
    int qSize;
    int maxSize = 5; // if not initialized

    public Queue(){
        this.queueArray = new long[this.maxSize];
        front = 0;
        rear = -1;
    }

    public Queue(int maxSize){
        this.maxSize = maxSize;
        this.queueArray = new long[maxSize];
        front = 0;
        rear = -1;
        qSize = 0;
    }   

    public void insert(long data){
        if(!isFull()) {
            queueArray[++rear] = data;
            qSize++;
            System.out.println("[INFO]: Enqueued " + data);
            return;
        }
        System.out.println("[INFO]: Enqueuing " + data);
        System.err.println("[ERROR]: Queue maxSize("+ maxSize +") full. Cannot enqueue the element " + data);
    }

    //Physical Queue
    public void remove(){
        // System.out.println(rear);
        long dequeuedElement = queueArray[0];
        if(!isEmpty()){
            for (int i = front; i < rear; i++) {
                queueArray[i] = queueArray[i+1];
            }
            rear--;
            System.out.println("\n[INFO]: Dequeud " + dequeuedElement);
            displayQueue();
            return;
        }
        System.out.println("\n[INFO]: Dequeuing");
        System.err.println("[ERROR]: Queue is empty. Cannot remove.");

    }

    public long peekFront(){
        return queueArray[front];
    }

    //Traditional Queue
    public void removeTraditional(){
        front++;
        displayQueue();
    }

    public boolean isFull(){
        return (rear + 1 == maxSize);
    }

    public boolean isEmpty(){
        return (rear == -1);
    }

    public int size(){
        return qSize;
    }

    public void displayQueue(){
        
        System.out.println("\nCURRENT QUEUE VIEW");
        System.out.println("------------------");
        
        if(!isEmpty()){
            System.out.print("FRONT <   ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            
            System.out.println("  < REAR");
        }
        else{
            System.err.println("[INFO] : Queue is empty. Nothing to display :(");
        }

    }

    public static void main(String[] args) {
        int qMaxSize = 10;
        Queue queue = new Queue(qMaxSize);

        long[] qData = {5,6,7,8,9,2,5,7,1,4,11};

        for (int i = 0; i < qData.length; i++) {
            queue.insert(qData[i]);
        }

        queue.displayQueue();

        System.out.println();

        int nIter = 11;
        while(nIter > 0){
            queue.remove();
            nIter--;
        }

        queue.remove();

    }
}



