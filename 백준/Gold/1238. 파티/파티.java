import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static class Node{
        int v;
        int cost;

        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        visit = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, cost));
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            dijkstra(i);
            int go = dist[X];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(visit, false);
            dijkstra(X);
            int come = dist[i];
            max = (go + come) > max ? (go + come) : max;
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(visit, false);
        }

        System.out.println(max);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(visit[now.v]) continue;
            else visit[now.v] = true;

            for(Node next : graph[now.v]){
                if(!visit[next.v] && dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}