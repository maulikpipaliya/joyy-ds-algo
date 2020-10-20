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
        // System.out.println("top = " + top);
        char poppedElement = '\0';
        if (!(isEmpty())) {
            // System.out.println("[INFO]: Poping " + peek() + " from the stack");
            poppedElement = stackArray[top--];
            System.out.println("[INFO]: popped element :  " + poppedElement);
        } else {
            System.out.println("[INFO]: poping from the stack");
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

        System.out.print("TOP > ");
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i]);
                System.out.print("  ");
            }
            System.out.println("> BOTTOM");
            return;
        }
        System.out.println("Stack is empty. Nothing to display :( ");

    }

    public String convertToString() {
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

public class BracketChecker {
    public static void main(String[] args) {
        String str = "a{b[c(f)}]d}e(";
        char[] delimiters = { '{', '}', '[', ']', '(', ')' };
        char[] delimitersOpening = { '{', '[', '(' };
        char[] delimitersClosing = { '}', ']', ')' };

        int strLen = str.length();
        Stack stack1 = new Stack(str.length());

        char ch, poppedChar;
        for (int i = 0; i < strLen; i++) {
            ch = str.charAt(i);
            if (new String(delimitersOpening).indexOf(ch) != -1) {
                stack1.push(ch);
            }

            if (new String(delimitersClosing).indexOf(ch) != -1) {
                System.out.println("[INFO]: next character in string is " + ch);
                poppedChar = stack1.pop();

                int delimiterIndex = new String(delimitersOpening).indexOf(poppedChar);
                // System.out.println(delimiterIndex);

                if(!stack1.isEmpty()){
                    if (ch == delimitersClosing[delimiterIndex] && poppedChar == delimitersOpening[delimiterIndex]) {
                        System.out.println("[INFO]: " + delimitersOpening[delimiterIndex] + " and " + delimitersClosing[delimiterIndex] + " matched");
                    } else {
                        System.err.println("\n[ERROR]: Should be " + delimitersClosing[delimiterIndex] + " but " + ch +  " found \n" );
                    }
                }
            }
        }
        
        stack1.displayStack();

        if (!stack1.isEmpty())
            System.out.println("\nBad String because good string keeps stack empty in the end!");


    }

    public static String getString() {
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
