
class Queue {

    private long[] queueArray = null;
    int front, rear;
    int qSize;
    int maxSize = 5; // if not initialized

    public Queue() {
        this.queueArray = new long[this.maxSize];
        front = 0;
        rear = -1;
    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new long[maxSize];
        front = 0;
        rear = -1;
        qSize = 0;
    }

    public void insert(long data) {
        
        // System.out.println("Front now: " + rear);
        if (!isFull()) {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = data;
            qSize++;
            
            System.out.print("[INFO]: Enqueued " + data + ". ");
            System.out.println(" At this point, rear: " + rear + " and front:" + front);
            return;
        }
        
        System.out.println("[INFO]: Enqueuing " + data);
        System.err.println("[ERROR]: Queue maxSize(" + maxSize + ") full. Cannot enqueue the element " + data);
    }
    
    // Physical Queue
    public void removePhysical() {
        // System.out.println(rear);
        long dequeuedElement = queueArray[0];
        if (!isEmpty()) {
            for (int i = front; i < rear; i++) {
                queueArray[i] = queueArray[i + 1];
            }
            rear--;
            System.out.println("\n[INFO]: Dequeud " + dequeuedElement);
            displayQueue();
            return;
        }
        System.out.println("\n[INFO]: Dequeuing");
        System.err.println("[ERROR]: Queue is empty. Cannot remove.");
        
    }
    
    public long peekFront() {
        return queueArray[front];
    }
    
    //Queue
    public long remove() {
        long dequeuedElement = queueArray[front];
        
        front = (front + 1) % maxSize; // to wrap around
        qSize--;
        
        System.out.print("[INFO]: Dequeued " + dequeuedElement + ". ");
        System.out.println(" At this point, rear: " + rear + " and front:" + front);
        // displayQueue();
        return dequeuedElement;
    }

    public boolean isFull() {
        return (qSize == maxSize);
    }
    
    public boolean isEmpty() {
        return (qSize == 0);
    }

    public int size() {
        return qSize;
    }

    public void displayQueue() {

        System.out.println("\nCURRENT QUEUE VIEW");
        System.out.println("------------------");
        System.out.println("At this point, rear: " + rear + " and front:" + front);

        if (!isEmpty()) {
            System.out.print("FRONT <   ");

            int tempMax = maxSize; 
            for (int i = front; i < tempMax; i++) {
                // System.out.print(queueArray[i] + " ");                    
                // if(i == maxSize - 1){
                    // i = 0;
                    // tempMax = rear;
                // }
            }

            /*
            8(10)
            At this point, rear: 3 and front:5
            index = 5 6 7 8 9 0 1 2 3 4 
            */ 
            // System.out.println( "lol" +qSize);
            for (int j = front; j < tempMax;) {
                System.out.print(j);
                if(j == maxSize - 1) {
                    j = (j + 1) % maxSize;
                    tempMax = rear;
                }
                else{
                    j++;
                }
                // System.out.print(()% maxSize + " ");
            }

        

            System.out.println("  < REAR");
        } else {
            System.out.println("[INFO] : Queue is empty. Nothing to display :(");
        }

    }

}

public class QueueApp {

    public static void main(String[] args) {
        int qMaxSize = 10;
        Queue queue = new Queue(qMaxSize);

        long[] qData = {1,2,3,4,5,6,7,8,9,10};

        for (int i = 0; i < qData.length; i++) {
            queue.insert(qData[i]);
        }

        queue.displayQueue();

        System.out.println();

        int nIter = 5;
        while(nIter > 0){
            queue.remove();
            nIter--;
        }

        queue.insert(15);
        queue.insert(16);
        queue.insert(17);
        queue.insert(18);
        

        queue.displayQueue();
        

    }
}