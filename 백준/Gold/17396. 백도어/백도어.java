import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int v;
    long cost;

    public Node(int v, long cost){
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    private static final long INF = 100000L * 100000 + 1 ;
    private static int N, M;
    private static ArrayList<Node>[] graph;
    private static boolean[] visit;
    private static int[] visible;
    private static long[] dist;

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Math.toIntExact(o1.cost - o2.cost));
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visit[now.v]) continue;
            else visit[now.v] = true;

            for(Node next : graph[now.v]){
                if(visible[next.v] != 1 && !visit[next.v] && dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visit = new boolean[N];
        dist = new long[N];
        visible = new int[N];

        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            visible[i] = Integer.parseInt(st.nextToken());
        }
        visible[N - 1] = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, t));
            graph[b].add(new Node(a, t));
        }

        dijkstra(0);

        if(dist[N - 1] == INF){
            System.out.println(-1);
        } else {
            System.out.println(dist[N - 1]);
        }
    }
}