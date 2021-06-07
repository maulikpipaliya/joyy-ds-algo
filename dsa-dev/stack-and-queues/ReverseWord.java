import java.io.BufferedReader;
import java.io.InputStreamReader;

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

    public String convertToString(){
        String str = "";
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                // System.out.print(stackArray[i]);
                str += stackArray[i];
            }
        }
        return str; 
    }
}

public class ReverseWord {
    public static void main(String[] args) {
        
        System.out.println("\n----------STACK APPLICATION----------\n");
      
        String reverseStr = "";

        System.out.print("Enter string : ");
        String str = getString();
        int wordLength = str.length();
        
        System.out.println("Given String is : " + str);

        Stack strCharStack = new Stack(wordLength);
        Stack strWordCharStack = new Stack(wordLength);
        
        for (int i = 0; i < wordLength; i++) {
            strCharStack.push(str.charAt(wordLength - i - 1));
        }

        strCharStack.displayStack();
        
        for (int i = 0; i < wordLength; i++) {
            strWordCharStack.push(strCharStack.pop());
        }

        strWordCharStack.displayStack();

        reverseStr = strWordCharStack.convertToString();

        System.out.println("Reversed Word is : " + reverseStr);
    
    }

    public static String getString(){
        String str = "";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            str = br.readLine();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return str;
    }
    
}
