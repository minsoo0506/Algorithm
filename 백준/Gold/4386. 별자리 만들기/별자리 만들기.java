import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Star{
    int id;
    double x;
    double y;

    public Star(int id, double x, double y){
        this.id = id;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int from;
    int to;
    double weight;

    public Edge(int from, int to, double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o){
        return Double.compare(this.weight, o.weight);
    }
}

public class Main {
    private static int n;
    private static double sum;
    private static Star[] stars;
    private static int[] parent;

    public static void makeParent(){
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
    }

    public static int find(int a){
        return (a == parent[a]) ? a : (parent[a] = find(parent[a]));
    }

    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;
        else {
            parent[b] = a;
            return true;
        }
    }

    public static double calculateWeight(Star s1, Star s2){
        double dx = s2.x - s1.x;
        double dy = s2.y - s1.y;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        stars = new Star[n + 1];
        parent = new int[n + 1];
        PriorityQueue<Edge> edges = new PriorityQueue<>();

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars[i] = new Star(i, x, y);
        }

        makeParent();

        for(int i = 1; i <= n; i++){
            for(int j = i + 1; j <= n; j++){
                edges.offer(new Edge(stars[i].id, stars[j].id, calculateWeight(stars[i], stars[j])));
            }
        }

        while (!edges.isEmpty()){
            Edge edge = edges.poll();
            if(union(edge.from, edge.to)){
                sum += edge.weight;
            }
        }

        System.out.printf("%.2f\n", sum);
        br.close();
    }
}