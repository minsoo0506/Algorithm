// 백준 1967 트리의 지름 : dfs로 풀이
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    private static int n;
    private static ArrayList<Edge>[] graph;
    private static boolean[] visit;
    private static int maxDistance;

    public static void dfs(int node, int cost){
        if(cost > maxDistance){
            maxDistance = cost;
        }

        visit[node] = true;
        for(Edge edge : graph[node]){
            if(!visit[edge.v]){
                dfs(edge.v, cost + edge.cost);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        maxDistance = 0;

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));
        }

        for(int i = 1; i <= n; i++) {
            dfs(i, 0);
            Arrays.fill(visit, false);
        }

        System.out.println(maxDistance);
    }
}