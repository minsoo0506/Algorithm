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
    private static int N, M;
    private static ArrayList<Edge>[] graph;
    private static int[] dist;
    private static boolean[] visit;

    public static void dijkstra(int start){
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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            dist = new int[N + 1];
            visit = new boolean[N + 1];

            for (int j = 0; j <= N; j++) {
                graph[j] = new ArrayList<>();
                dist[j] = INF;
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a].add(new Edge(b, c));
                graph[b].add(new Edge(a, c));
            }

            int K = Integer.parseInt(br.readLine());
            int[] place = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++){
                dijkstra(Integer.parseInt(st.nextToken()));
                for(int k = 1; k <= N; k++){
                    place[k] += dist[k];
                }
                Arrays.fill(visit, false);
                Arrays.fill(dist, INF);
            }

            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 1; j <= N; j++){
                if(min > place[j]){
                    min = place[j];
                    minIndex = j;
                }
            }
            sb.append(minIndex).append("\n");
        }

        System.out.println(sb);
    }
}