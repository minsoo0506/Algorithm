import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Barn {
    int v;
    int cost;

    public Barn(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    static ArrayList<Barn>[] graph;
    static boolean[] visit;
    static int[] dist;

    public static void dijkstra(int start){
        PriorityQueue<Barn> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Barn(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Barn now = pq.poll();

            if(!visit[now.v]) visit[now.v] = true;
            else continue;

            for(Barn next : graph[now.v]){
                if(!visit[next.v] && dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Barn(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());
            int C_i = Integer.parseInt(st.nextToken());
            graph[A_i].add(new Barn(B_i, C_i));
            graph[B_i].add(new Barn(A_i, C_i));
        }

        dijkstra(1);

        System.out.println(dist[N]);
    }
}
