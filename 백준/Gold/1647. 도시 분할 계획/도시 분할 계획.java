import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    private static int N, M;
    private static PriorityQueue<Edge> edges;
    private static int[] parent;

    public static void makeParent(){
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
    }

    public static int find(int a){
        return (a == parent[a]) ? a : (parent[a] = find(parent[a]));
    }

    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return true;
        else {
            parent[b] = a;
            return false;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        edges = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.offer(new Edge(from, to, cost));
        }

        makeParent();

        PriorityQueue<Integer> minEdgeList = new PriorityQueue<>(Collections.reverseOrder());
        while(!edges.isEmpty()){
            Edge edge = edges.poll();
            if(!union(edge.from, edge.to)){
                minEdgeList.offer(edge.cost);
            }
        }

        minEdgeList.poll();

        int minSum = 0;
        while(!minEdgeList.isEmpty()){
            minSum += minEdgeList.poll();
        }

        System.out.println(minSum);
    }
}