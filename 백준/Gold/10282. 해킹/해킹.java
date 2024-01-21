import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int[] dist;

    static class Node{
        int v;
        int cost;

        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visit[now.v]) continue;
            else visit[now.v] = true;

            for(Node next : graph[now.v]){
                if(!visit[next.v] && dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            visit = new boolean[n + 1];
            dist = new int[n + 1];

            for(int j = 1; j <= n; j++){
                graph[j] = new ArrayList<>();
                dist[j] = Integer.MAX_VALUE;
            }

            for(int j = 0; j < d; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new Node(a, s));
            }

            dijkstra(c);
            int count = 0;
            int maxTime = 0;
            for(int j = 1; j <= n; j++){
                if(visit[j] == true) count++;
                if(dist[j] != Integer.MAX_VALUE){
                    maxTime = Math.max(maxTime, dist[j]);
                }
            }
            sb.append(count).append(" ").append(maxTime).append("\n");
        }

        System.out.print(sb);
    }
}