class Stack {

    private char[] stackArray = null;
    private int maxSize = 5;
    private int top;

    public Stack() {
        this.stackArray = new char[maxSize];
        top = -1;

    }

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char data) {

        if (!isFull()) {
            stackArray[++top] = data;
            System.out.println("[INFO]: " + data + " pushed onto the stack");
            return;
        } else {
            System.out.println("[INFO]: Pushing " + data);
            System.err.println("\n[ERROR]: StackOverflow : " + data
                    + " couldn't be pushed because stack size is maximum " + maxSize + ".\n");
        }
    }

    public char peek() {

        try {
            return stackArray[top];
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return '\0';
        }
    }

    public char pop() {
        System.out.println("----------------------------------------");
        // System.out.println("top = " + top);
        char poppedElement = '\0';
        if (!(isEmpty())) {
            // System.out.println("[INFO]: Poping " + peek() + " from the stack");
            poppedElement = stackArray[top--];
            System.out.println("[INFO]: Popped element :  " + poppedElement);
        } else {
            System.out.println("[INFO]: Poping from the stack");
            System.err.println("[ERROR]: Stack Underflow - not able to pop, stack is already empty");
        }
        return poppedElement;
    }

    public int stackSize() {
        return top + 1;
    }

    public boolean isFull() {
        return (top + 1 == maxSize);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void displayStack() {

        System.out.println("\nCURRENT STACK VIEW");
        System.out.println("----------------------------------------");

        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.print("|  ");
                System.out.print(stackArray[i]);
                System.out.println("   |");
            }
            System.out.println("````````");
            return;
        }
        System.out.println("Stack is empty. Nothing to display :( ");

    }
}

public class ReverseWord {
    public static void main(String[] args) {
        System.out.println("\n----------STACK APPLICATION----------\n");
        
        char[] sData = { 'j', 'o', 'y', 'y' };
        int sDataLen = sData.length;
        char[] sReverse = new char[sDataLen];

        Stack mainStack = new Stack(sDataLen);
        int iterPush = 0;

        Stack reverseStack = new Stack(sDataLen);

        
        // reverseStack.displayStack();
        
        System.out.println(sDataLen);
        while (iterPush < sDataLen) {
            mainStack.push(sData[iterPush]);
            iterPush++;
        }
        
        mainStack.displayStack();
        
        for (int i = 0; i < sReverse.length; i++) {
                reverseStack.push(mainStack.pop());
                // System.out.println(stack.pop());
        }

        reverseStack.displayStack();
    
        // mainStack.displayStack();
    }
}
