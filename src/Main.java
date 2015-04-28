package src;

import java.util.Random;


public class Main {

    private static final int VIRTUAL_NET_SIZE = 21;
    private static final int MAX_COST = 20;
    private static final String SOURCE_NODE = "A";
    private static final String DEST_NODE = "I";


    public static void main(String[] args) {


        /*****************************************************************
        ******************************************************************
        **
        ** This block instantiates a virtual network, assigns random
        **  costs to its edges, then uses the virtual network to create
        **  an undirected graph. The Dijkstra algorithm is implmented on
        **  this graph before results printed.
        **
        ******************************************************************
        ******************************************************************/
        Network virtualNet = new Network();
        setRandomCosts(virtualNet);
        UGraph graph = new UGraph(virtualNet);
        graph.dijkstra(SOURCE_NODE);
        graph.makeLabels();
        printResults(graph);

    }

    private static void setRandomCosts(Network vn){

        int size = vn.getNet().length;
        int nextCost;

        // get random numbers
        Random ran = new Random();
        for (int i = 0; i < size; i++) {
            nextCost = ran.nextInt((MAX_COST) -1 )+1;
            vn.getNet()[i].setDist(nextCost);
        }
    }

    private static void printResults(UGraph graph){

        System.out.println("Network Size: " + VIRTUAL_NET_SIZE);
        System.out.println("Dijkstra from Source: " + SOURCE_NODE);


        System.out.println("\nAll Paths From Root " + SOURCE_NODE);
        graph.printAllPaths();

        System.out.println("\nBest Path From " + SOURCE_NODE + " to " + DEST_NODE + ": ");
        graph.printPath(DEST_NODE);


    }
}
