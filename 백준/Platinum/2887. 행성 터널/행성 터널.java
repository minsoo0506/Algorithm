import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Planet{
    int id;
    int x;
    int y;
    int z;

    public Planet(int id, int x, int y, int z){
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    private static int N, sum;
    private static int[] parent;
    private static Planet[] planets;

    public static int calculateCost(Planet p1, Planet p2) {
        int dx = Math.abs(p1.x - p2.x);
        int dy = Math.abs(p1.y - p2.y);
        int dz = Math.abs(p1.z - p2.z);

        return Math.min(dx, Math.min(dy, dz));
    }

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

        if(a == b) return false;
        else {
            parent[b] = a;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        planets = new Planet[N + 1];
        parent = new int[N + 1];
        PriorityQueue<Edge> edges = new PriorityQueue<>();

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i] = new Planet(i, x, y, z);
        }

        makeParent();

        Arrays.sort(planets, 1, N + 1, (p1, p2) -> p1.x - p2.x);
        for(int i = 1; i < N; i++) {
            edges.offer(new Edge(planets[i].id, planets[i + 1].id, calculateCost(planets[i], planets[i + 1])));
        }

        Arrays.sort(planets, 1, N + 1, (p1, p2) -> p1.y - p2.y);
        for(int i = 1; i < N; i++) {
            edges.offer(new Edge(planets[i].id, planets[i + 1].id, calculateCost(planets[i], planets[i + 1])));
        }

        Arrays.sort(planets, 1, N + 1, (p1, p2) -> p1.z - p2.z);
        for(int i = 1; i < N; i++) {
            edges.offer(new Edge(planets[i].id, planets[i + 1].id, calculateCost(planets[i], planets[i + 1])));
        }

        while(!edges.isEmpty()){
            Edge edge = edges.poll();
            if(union(edge.from, edge.to)){
                sum += edge.weight;
            }
        }

        System.out.println(sum);
        br.close();
    }
}