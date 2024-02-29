import java.util.*;
import java.io.*;

public class Main {
    static int nodeCount, edgeCount, startNode;
    static int[] depth, visitOrder;
    static ArrayList<Integer>[] adjacencyList;
    static long totalDepthTimesOrder = 0;
    static int visitCounter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        nodeCount = Integer.parseInt(tokenizer.nextToken());
        edgeCount = Integer.parseInt(tokenizer.nextToken());
        startNode = Integer.parseInt(tokenizer.nextToken());

        depth = new int[nodeCount + 1];
        visitOrder = new int[nodeCount + 1];
        adjacencyList = new ArrayList[nodeCount + 1];

        for (int i = 1; i <= nodeCount; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int node1 = Integer.parseInt(tokenizer.nextToken());
            int node2 = Integer.parseInt(tokenizer.nextToken());

            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }

        for (int i = 1; i <= nodeCount; i++) {
            Collections.sort(adjacencyList[i]);
        }

        Arrays.fill(depth, -1);
        depth[startNode] = 0;

        performDepthFirstSearch(startNode, 0);
        System.out.println(totalDepthTimesOrder);
    }

    static void performDepthFirstSearch(int currentNode, int currentDepth) {
        depth[currentNode] = currentDepth;
        visitOrder[currentNode] = ++visitCounter;
        totalDepthTimesOrder += (long) visitOrder[currentNode] * currentDepth;

        for (int adjacentNode : adjacencyList[currentNode]) {
            if (depth[adjacentNode] != -1) {
                continue;
            }
            performDepthFirstSearch(adjacentNode, currentDepth + 1);
        }
    }
}