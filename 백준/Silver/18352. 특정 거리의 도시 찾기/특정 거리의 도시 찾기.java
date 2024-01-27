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

    public static void dijkstra(int start){
        PriorityQueue<City> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new City(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            City now = pq.poll();

            if(!visited[now.v]){
                visited[now.v] = true;
            }

            for(City next : graph[now.v]){
                if(!visited[next.v] && dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost;
                    pq.offer(new City(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(new City(B, 1));
        }

        dijkstra(X);

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(i == X) continue;
            else {
                if(dist[i] == K){
                    sb.append(i).append("\n");
                    count++;
                }
            }
        }

        System.out.print((count != 0) ? sb : -1);
    }
}