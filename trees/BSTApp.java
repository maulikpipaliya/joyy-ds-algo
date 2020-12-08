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
        private int data;
        private BTNode leftChild;
        private BTNode rightChild;

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

    }

    public void insertBTNode(int data){
        
        if (root == null) {
            root = new BTNode(data);
            return;
        }
        else {
            BTNode current = root;
            BTNode parent = null;

            while (true) {
                parent = current;

                if (data < parent.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = new BTNode(data);
                    }
                }
                else {
                    current = current.rightChild;
                    if (current == null) {
                        current.rightChild = new BTNode(data);
                    }
                }
                
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Heyyy");
        BTNode r = root;
        while(r != null){
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
        binaryTree.insertBTNode(8);
        binaryTree.insertBTNode(9);
        binaryTree.insertBTNode(10);
        System.out.println(binaryTree);

    }
}
