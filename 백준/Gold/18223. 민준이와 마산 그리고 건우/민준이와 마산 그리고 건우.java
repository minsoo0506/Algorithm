import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge{
    int v;
    int cost;

    public Edge(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}



public class Main {
    private static final int INF = Integer.MAX_VALUE;
    private static int V, E, P;
    private static ArrayList<Edge>[] graph;
    private static int[] dist;
    private static boolean[] visit;

    public static int dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(visit[now.v]) continue;
            else visit[now.v] = true;

            for(Edge next : graph[now.v]){
                if(!visit[next.v] && dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        visit = new boolean[V + 1];

        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        int normalDist = dijkstra(1, V);
        Arrays.fill(dist, INF);
        Arrays.fill(visit, false);
        int startToP = dijkstra(1, P);
        Arrays.fill(dist, INF);
        Arrays.fill(visit, false);
        int PToEnd = dijkstra(P, V);

        int distViaP = startToP + PToEnd;

        if(normalDist >= distViaP){
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }
}