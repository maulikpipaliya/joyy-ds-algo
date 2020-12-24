import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

class Graph {
    int[] graphArray;
    
    private boolean adjMatrix[][];
    int vertexCount;
    int weight = 1;
    
    public Graph() {
        this.vertexCount = 0;
    }
    
    public Graph(int nVertex) {
        this.vertexCount = 0;
        adjMatrix = new boolean[nVertex][nVertex];
        graphArray = new int[nVertex];
    }
    
    //Adds a vertex to the graph.
    public boolean add(int data) {
        graphArray[vertexCount++] = data;
        return true;
    }

    // Creates a connection between two vertices. 
    public void connect(int from, int to) {
        //directed graph
        adjMatrix[from - 1][to - 1] = true;
    }
    
    public boolean contains(int number) {
        for (int i = 0; i < vertexCount; i++) {
            if (graphArray[i] == number)
                return true;
        }
        return false;
    }

    // Returns the list of vertices that a connects to a specified vertex.
    public boolean[] getInwardEdges(int to) {
        boolean[] inwardEdges = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            // System.out.println(adjMatrix[i][to - 1]);
            if (adjMatrix[i][to - 1]) {
                inwardEdges[i] = true;
            } else {
                inwardEdges[i] = false;
            }
        }
        return inwardEdges;
    }

    // Returns the list of vertices that a specified vertex connects to.
    public boolean[] getOutwardEdges(int from) {
        boolean[] outwardEdges = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[from - 1][i]) {
                outwardEdges[i] = true;
            } else {
                outwardEdges[i] = false;
            }
        }
        return outwardEdges;
    }

    

    public void displayGraph() {
        for (int i : graphArray) {
            System.out.print(i + ",");
        }
    }

    public void displayGraphMatrix() {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (adjMatrix[i][j])
                    System.out.print(weight + " ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    /*
        Traversal Algos - BFS - DFS
    */


    /**
     * 
     *  1. Visit the adjacent unvisited vertex. Mark it as visited. Display it. Insert it in a queue.
        2. If no adjacent vertex is found, remove the first vertex from the queue.
        3. Repeat step 1 and step 2 until the queue is empty.

     */
    public void bfs() {
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> q = new LinkedList<Integer>();
        int[] bfsArray = new int[vertexCount];

        int i = 0;
        int t = Integer.MIN_VALUE;
        q.add(graphArray[i]);
        boolean[] adjBoolean;
        while (!q.isEmpty()) {
            visited[i] = true;
            t = q.remove();
            System.out.println(t);
            adjBoolean = this.getOutwardEdges(t);
            for (int j = 0; j < adjBoolean.length; j++) {
                if (adjBoolean[j]) {
                    if (!visited[j]) {
                        q.add(graphArray[j]);
                        visited[j] = true;
                    }
                }
            }

        }

        System.out.println(q);

    }
 
  /**
     * 
     * 
     *  1. Visit the adjacent unvisited vertex. Mark it as visited. Display it (processing). Push it onto a stack.
        2. If no adjacent vertex is found, pop up a vertex from the stack. (It will pop up all the vertices from the stack, which do not have
    adjacent vertices.)
        3. Repeat step 1 and step 2 until the stack is empty
     */
    public void dfs() {
        boolean[] visited = new boolean[vertexCount];

        Stack<Integer> stack = new Stack<Integer>();

        int i = 0;
        stack.push(graphArray[i]);
        int t = Integer.MIN_VALUE;
        boolean[] adjBooleans = new boolean[vertexCount];
        
        while(!stack.isEmpty()){
            visited[i] = true;
            
            t = stack.pop();

            if (!visited[i]) {
                System.out.println(graphArray[i]);
                visited[i] = true;

                for (int j = vertexCount-1; j >= 0; j--) {
                    if (!visited[j]) {
                        stack.push(graphArray[j]);
                    }
                }
            
            }
            i++;
            // System.out.print(t + ",");
            
        
        }
    }
    
  
}

public class GraphApp {
    public static void main(String[] args) {
        // clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("GRAPH IMPLEMENTATION");
        int[] gArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        

        Graph graph = new Graph(9);

        for (int i : gArr) {
            graph.add(i);
        }

        graph.connect(1,2);
        graph.connect(1,4);
        graph.connect(2,3);
        graph.connect(3,4);
        graph.connect(3,5);
        graph.connect(4,7);
        graph.connect(5,4);
        graph.connect(6,5);
        graph.connect(7,6);
        graph.connect(7,9);
        graph.connect(8,4);
        graph.connect(8,7);
        graph.connect(9, 6);
        
        // graph.getInwardEdges(4);
        // System.out.println(graph.getInwardEdges(4));

        graph.getOutwardEdges(3);
     
        // graph.bfs();
        graph.dfs();

        System.out.println();
        graph.displayGraphMatrix();

    }

}
