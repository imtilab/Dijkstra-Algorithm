
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra_Algorithm {

    Scanner kb = new Scanner(System.in);
    Queue<Integer> queue = new LinkedList<>();
    double distance[];
    int vertices, edges;
    double graph[][];
    int parent[];
    int source, destination;

    public void setGraph() {

        System.out.println("How many Verices?");
        vertices = kb.nextInt();
        System.out.println("How many Edges?");
        edges = kb.nextInt();

        System.out.println("Enter Source: ");
        source = kb.nextInt();
        System.out.println("Enter Destination: ");
        destination = kb.nextInt();

        graph = new double[vertices + 1][vertices + 1];

        for (int i = 0; i < edges; i++) {
            System.out.println("From: ");
            int from = kb.nextInt();
            System.out.println("To: ");
            int to = kb.nextInt();
            System.out.println("Weight: ");
            int weight = kb.nextInt();
            graph[from][to] = weight;
        }
        distance = new double[vertices + 1];
        parent = new int[vertices + 1];
    }
    //dijkstra algo
    public void Dijkstra() {
        for (int i = 1; i < distance.length; i++) {//initial distance infinity
            distance[i] = 99999;
        }

        distance[source] = 0;
        for (int v = 1; v <= vertices; v++) {
            queue.add(v);
        }

        Dijkstra_visit();

        printResult();
    }

    public void Dijkstra_visit() {

        while (!queue.isEmpty()) {
            Priority.setPriority(queue, distance);
            int parentVer = (int) queue.poll();

            //check for all adjacency vertices of the visisted vertex
            for (int adjacentVer = 1; adjacentVer < graph[0].length; adjacentVer++) {
                
                if (graph[parentVer][adjacentVer] > 0) {//weight exists
                    if (distance[adjacentVer] > distance[parentVer] + graph[parentVer][adjacentVer]) {
                        
                        distance[adjacentVer] = distance[parentVer] + graph[parentVer][adjacentVer];
                        parent[adjacentVer] = parentVer;//keeps parent ver
                    }
                }
            }
        }
    }

    //print distance and path
    public void printResult() {
        //cost from source to each node
        for (int c = 2; c < distance.length; c++) {
            System.out.println("distance from " + source + " to " + c + ": " + distance[c]);
        }

        //path from source to destination
        int dest = destination;
        String path = "" + dest;
        while (true) {
            path = parent[dest] + " --> " + path;
            dest = parent[dest];
            if (dest == source) {
                break;
            }
        }
        System.out.println(path);
    }

    //print Matrix    
    public void showGraph() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
