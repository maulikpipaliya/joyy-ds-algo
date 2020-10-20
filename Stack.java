public class Stack {

    private long[] arr = null;
    private int capacity = 5;
    private int top;

    public Stack(){
        this.arr = new long[capacity]; 
    }

    public Stack(int capacity){
        this.capacity = capacity;
        this.arr = new long[capacity]; 
        top = -1;
    }

    public void push(long data){
        
        System.out.println("[INFO]: Pushing " + data);
        if(!isStackFull()){
            arr[++top] = data;
            System.out.println("[INFO]: " + data + " pushed onto the stack");
        }
        else{
            System.err.println("\n[ERROR]: StackOverflow : "+ data + " couldn't be pushed because stack size is maximum " + capacity +  ".\n");
        }
    }

    public long peek(){
        try{
            return arr[top];
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public long pop(){
        System.out.println("----------------------------------------");
        
        // int poppedElement;
        if(!isStackEmpty()){
            System.out.println("[INFO]: Poping " + peek() + " from the stack");
            long poppedElement = arr[top--];
            System.out.println("[INFO]: Popped element :  " + poppedElement);
            return poppedElement;                
        }
        else{
            System.err.println("[ERROR]: Stack Underflow - not able to pop, stack is already empty");
            return -1;
        }
    }

    public int stackSize(){
        return top + 1;
    }

    public boolean isStackFull(){
        return (top + 1 == capacity);
    }

    public boolean isStackEmpty(){
        return (top == -1);
    }

    public void displayStack(){
        System.out.println("----------------------------------------");
        System.out.println("CURRENT STACK VIEW");
        System.out.println("----------------------------------------");
        for (int i = top; i >= 0; i--) {
            System.out.print("|  ");
            System.out.print(arr[i]);
            System.out.println("   |");
        }
        
        System.out.println("````````");   
    }


    public static void main(String[] args) {
        int sCapacity = 4;
        Stack stack = new Stack(sCapacity);
        System.out.println("\n----------STACK IMPLEMENTATION----------\n");        

        long[] sData = {3,5,6,7,8};
        //stack.pop();
        int iterPush = sData.length;
        while(iterPush > 0){
            stack.push(sData[iterPush]);
            iterPush--;
        }
        
        stack.displayStack();
        
        System.out.println(stack.stackSize());
        
        int iterPop = 3;
        while(iterPop > 0){
            stack.pop();
            iterPop--;
        }

        // System.out.println(stack.peek());
    }
}





