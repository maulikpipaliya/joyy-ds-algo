class CircularQueue {

    private long[] queueArray = null;
    int front, rear;
    int qSize;
    int maxSize = 5; // if not initialized

    public CircularQueue() {
        this.queueArray = new long[this.maxSize];
        front = 0;
        rear = -1;
    }

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new long[maxSize];
        front = 0;
        rear = -1;
        qSize = 0;
    }

    public void insert(long data) {
        if (!isFull()) {
            queueArray[++rear] = data;
            qSize++;
            System.out.println("[INFO]: Enqueued " + data);
            return;
        }
        System.out.println("[INFO]: Enqueuing " + data);
        System.err.println("[ERROR]: Queue maxSize(" + maxSize + ") full. Cannot enqueue the element " + data);
    }

    // Physical Queue
    public void remove() {
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

    // Traditional Queue
    public void removeTraditional() {
        front++;
        displayQueue();
    }

    public boolean isFull() {
        return (rear + 1 == maxSize);
    }

    public boolean isEmpty() {
        return (rear == -1);
    }

    public int size() {
        return qSize;
    }

    public void displayQueue() {

        System.out.println("\nCURRENT QUEUE VIEW");
        System.out.println("------------------");

        if (!isEmpty()) {
            System.out.print("FRONT <   ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }

            System.out.println("  < REAR");
        } else {
            System.err.println("[INFO] : Queue is empty. Nothing to display :(");
        }

    }

}


public class CircularQueueApp {
    public static void main(String[] args) {
        int cqMaxSize = 5;
        CircularQueue cQueue = new CircularQueue(cqMaxSize);

        

    }
}
