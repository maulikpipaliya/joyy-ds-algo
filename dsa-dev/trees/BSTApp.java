import java.util.*;

/*
Inserting an element into a tree
• Deleting an element from a tree
• Searching for an element
• Traversing the tree


• Finding the size of the tree
• Finding the height of the tree
• Finding the level which has maximum sum
• Finding the least common ancestor (LCA) for a given pair of nodes, and many more.
*/

class BinaryTree {

    BTNode root = null;
    int height, depth;
    int nElems;

    class BTNode {
        int data;
        BTNode leftChild;
        BTNode rightChild;

        public BTNode(int data) {
            this.data = data;
            leftChild = null;
            rightChild = null;
        }

        public int getBTNodeData() {
            return this.data;
        }

        public void setBTNodeData(int data) {
            this.data = data;
        }

        public int getLeftBTNodeData() {
            return this.leftChild.data;
        }

        public int getRightChildBTNodeData() {
            return this.rightChild.data;
        }

        public BTNode getLeftBTNode() {
            return this.leftChild;
        }

        public BTNode getRightBTNode() {
            return this.rightChild;
        }

        public void setLeftBTNodeData(int data) {
            this.leftChild = new BTNode(data);
        }

        public void setRightBTNodeData(int data) {
            this.rightChild = new BTNode(data);
        }

        public void setRightBTNode(BTNode node) {
            this.rightChild = node;
        }

        public void setLeftBTNode(BTNode node) {
            this.leftChild = node;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (this.leftChild != null)
                sb.append(this.leftChild.data + "->");
            else
                sb.append("null" + "->");

            sb.append(this.data);

            if (this.rightChild != null) {
                sb.append("<-" + this.rightChild.data);
            } else {
                sb.append("<-" + "null");

            }
            sb.append("\n");
            return sb.toString();
        }
    }

    public void insertBTNode(int data) {

        // Discard Duplicate Values
        if (this.contains(root, data))
            return;

        if (root == null) {
            root = new BTNode(data);
            return;
        } else {
            BTNode current = root;
            BTNode parent;

            while (true) {

                parent = current;

                // goes to left subtree
                if (data < current.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = new BTNode(data);
                        return;
                    }
                } else {
                    // goes to right subtree
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = new BTNode(data);
                        return;
                    }
                }
            }
        }
    }

    /*
     * 
     * 5 3 7 1 4 6 8 PreOrder = DLR = 5,3,1,4,7,6,8 Inorder = LDR = 1,3,4,5,6,7,8 =
     * sorted PostOrder = LRD = 1,4,3,6,8,7,5
     * 
     */

    public BTNode findBTNodeWithData(BTNode r, int data) {
        if (r == null)
            return null;

        if (data == r.data)
            return r;

        if (data < r.data) {
            return findBTNodeWithData(r.leftChild, data);
        } else {
            return findBTNodeWithData(r.rightChild, data);
        }
    }

    public int getHeight(BTNode r) {
        if (r == null)
            return -1;
        return Math.max(getHeight(r.leftChild), getHeight(r.rightChild)) + 1;
    }

    public int findMinimum(BTNode r) {
        if (r == null)
            return Integer.MIN_VALUE;
        while (r.leftChild != null) {
            r = r.getLeftBTNode();
        }
        return r.data;
    }

    public int findMaximum(BTNode r) {
        if (r == null)
            return Integer.MAX_VALUE;

        while (r.rightChild != null) {
            r = r.getRightBTNode();
        }
        return r.data;
    }

    public ArrayList<Integer> getLargeNumbers(int number) {
        BTNode node = findBTNodeWithData(root, number);
        ArrayList<Integer> list = new ArrayList<>();
        if (node != null) {
            // inOrder(node.leftChild);
            System.out.print(node.data + ",");
            list.add(node.data);
            inOrder(node.rightChild);
        }
        return list;
    }

    // LDR = InOrder
    public ArrayList<Integer> inOrderIterative(BTNode r) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<BTNode> treeStack = new Stack<BTNode>();
        BTNode current = root;

        while (true) {
            if (current != null) {
                treeStack.push(current);
                current = current.leftChild;
            } else {
                if (treeStack.isEmpty())
                    break;
                else {
                    current = treeStack.pop();
                    list.add(current.data);
                    current = current.rightChild;
                }
            }
        }
        return list;
    }

 

    public boolean contains(BTNode r, int data) {
        return (findBTNodeWithData(r, data) != null) ? true : false;
    }

    // Time Complexity: O(n). Space Complexity: O(n)
    // DLR = PreOrder
    void preOrder(BTNode r) {
        if (r != null) {
            System.out.print(r.data + ",");
            preOrder(r.leftChild);
            preOrder(r.rightChild);
        }
    }

    // LDR = InOrder
    void inOrder(BTNode r) {
        if (r != null) {
            inOrder(r.leftChild);
            System.out.print(r.data + ",");
            inOrder(r.rightChild);
        }
    }

    // LRD = PostOrder
    void postOrder(BTNode r) {
        if (r != null) {
            postOrder(r.leftChild);
            postOrder(r.rightChild);

            System.out.print(r.data + ",");
        }
    }

    // DLR = PreOrder
    // Time Complexity: O(n). Space Complexity: O(n)
    public ArrayList<Integer> preOrderIterative() {
        ;
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;

        Stack<BTNode> treeStack = new Stack<BTNode>();

        treeStack.push(root);

        while (!treeStack.isEmpty()) {
            BTNode temp = treeStack.pop();
            list.add(temp.data);

            if (temp.rightChild != null) {
                treeStack.push(temp.rightChild);
            }
            // right subtree will be pushed first and left subtree will be pushed later.
            // This way left subtree will be popped first and saved in the array.
            if (temp.leftChild != null) {
                treeStack.push(temp.leftChild);
            }
        }
        /*
         * 
         * Full-stack = 5, 7, 3, 4, 1, 8, 6 list = 5, 3, 1, 4, 7, 6, 8
         */

        return list;
    }

    // LDR = InOrder
    public ArrayList<Integer> inOrderIterative() {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        Stack<BTNode> treeStack = new Stack<BTNode>();
        treeStack.push(root);
        while (!treeStack.isEmpty()) {
            BTNode temp = treeStack.pop();
            if (temp.leftChild != null) {
                treeStack.push(temp.leftChild);
                list.add(temp.leftChild.data);
            }
            // treeStack.push(temp);
            // list.add(temp.data);
            if (temp.rightChild != null) {
                treeStack.push(temp.rightChild);
                list.add(temp.rightChild.data);
            }

            // list.add(temp.data);
        }

        return list;
    }


    public void displayTree() {
        int height = this.getHeight(root);
        // System.out.println(height);

        int tempH = 4;
        int temp = tempH;
        int c = 0;
        int[] a3 = { 1, 3, 4, 5, 6, 7, 8 };
        int[] b4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5 };
        for (int i = 0; i < tempH; i++) {
            for (int j = 0; j < temp; j++) {
                System.out.print(" ");
            }
            temp--;
            System.out.println(a3[c++]);
        }

        System.out.println("-----");
        temp = 4;
        int temp2 = 8;
        c = 0;
        int x = 1;
        for (int i = 0; i < 4; i++) {
            //leading spaces
            for (int j = 0; j < (temp * 2) - 1; j++) {
                System.out.print(" ");
            }
            temp = temp / 2;

            for (int j = 0; j < x; j++) {
                System.out.print(b4[c++]);
                for (int k = 0; k <= ((temp2) - 1) * 2; k++) {
                    System.out.print(" ");
                }
            }
            temp2 = temp2 / 2;
            x = x * 2;

            System.out.println();

        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Heyyy");
        BTNode r = root;
        while (r != null) {
            System.out.println(r.data);
            r = r.leftChild;
        }

        return sb.toString();
    }
}

public class BSTApp {
    public static void main(String[] args) {
        // To clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Program run
        System.out.println("Hello");
        BinaryTree binaryTree = new BinaryTree();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // Adding root node
        binaryTree.insertBTNode(5);
        int[] a = { 5, 3, 1, 4, 7, 6, 8 };

        for (int i : a) {
            binaryTree.insertBTNode(i);
        }

        System.out.println(binaryTree);

        System.out.println("------------");
        // System.out.println(binaryTree.preOrderIterative());
        // binaryTree.preOrder(binaryTree.root);
        System.out.println("PreOrder Traversal");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        System.out.println(binaryTree.preOrderIterative());
        System.out.println();
        System.out.println("InOrder Traversal");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        System.out.println(binaryTree.inOrderIterative());
        System.out.println();
        System.out.println("PostOrder Traversal");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        System.out.println();

        System.out.println("------------");
        System.out.println(binaryTree.findBTNodeWithData(binaryTree.root, 15));

        System.out.println(binaryTree.getHeight(binaryTree.root));

        System.out.println("Minimum Value: " + binaryTree.findMinimum(binaryTree.root));
        System.out.println("Maximum Value: " + binaryTree.findMaximum(binaryTree.root));
        System.out.println(binaryTree.getLargeNumbers(7));
        System.out.println("\nInOrder Iterative");
        System.out.println(binaryTree.inOrderIterative(binaryTree.root));
        
        binaryTree.displayTree();
    }

}
