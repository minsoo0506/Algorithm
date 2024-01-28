import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class City{
    int v;
    int cost;

    public City(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    static ArrayList<City>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int[] prev;

    public static void dijkstra(int start){
        PriorityQueue<City> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new City(start, 0));
        dist[start] = 0;
        prev[start] = 0;

        while(!pq.isEmpty()){
            City now = pq.poll();

            if(!visited[now.v]) visited[now.v] = true;
            else continue;

            for(City next : graph[now.v]){
                if(!visited[next.v] && dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost;
                    pq.offer(new City(next.v, dist[next.v]));
                    prev[next.v] = now.v;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        prev = new int[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new City(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while(current != 0){
            routes.add(current);
            current = prev[current];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");
        sb.append(routes.size()).append("\n");
        for(int i = routes.size() - 1; i >= 0; i--){
            sb.append(routes.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}