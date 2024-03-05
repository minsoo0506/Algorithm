import java.util.*;
import java.io.*;

class Node{
    int v;
    int cost;

    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    private static final int INF = 200000000;
    private static int N, E;
    private static int v1, v2;
    private static ArrayList<Node>[] graph;
    private static int[] dist;
    private static boolean[] visit;

    public static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(visit, false);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();

            if(visit[now.v]) continue;
            else visit[now.v] = true;


            for (Node next : graph[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        visit = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        br.close();

        int path1 = 0;
        path1 += dijkstra(1, v1);
        path1 += dijkstra(v1, v2);
        path1 += dijkstra(v2, N);

        int path2 = 0;
        path2 += dijkstra(1, v2);
        path2 += dijkstra(v2, v1);
        path2 += dijkstra(v1, N);

        if ((path1 >= INF) && (path2 >= INF)) System.out.println(-1);
        else System.out.println(Math.min(path1, path2));
    }
}