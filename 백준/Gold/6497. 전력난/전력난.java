import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class Main {
    private static int m, n;
    private static int[] parent;

    public static void makeParent(){
        for(int i = 0; i < m; i++){
            parent[i] = i;
        }
    }

    public static int find(int a){
        return (a == parent[a]) ? a : (parent[a] = find(parent[a]));
    }

    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;
        else {
            parent[b] = a;
            return true;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(m != 0 && n != 0) {
            parent = new int[m];
            int totalCost = 0;

            makeParent();

            PriorityQueue<Edge> edges = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                edges.offer(new Edge(x, y, z));
                totalCost += z;
            }

            while (!edges.isEmpty()) {
                Edge edge = edges.poll();
                if (union(edge.from, edge.to)) {
                    // 가로등을 사용하는 데 필요한 최소 비용이 아닌,
                    // 절약할 수 있는 최대 비용을 구해야 함.
                    totalCost -= edge.cost;
                }
            }

            sb.append(totalCost).append("\n");
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
        br.close();
    }
}