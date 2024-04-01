import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    private static int N, M, sum;
    private static int[] parent;
    private static Edge[] edgeList;

    public static void makeParent(){
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
    }

    public static int find(int x){
        return (x == parent[x]) ? x : (parent[x] = find(parent[x]));
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return false;
        else {
            parent[y] = x;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edgeList = new Edge[M];

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(a, b, c);
        }

        Arrays.sort(edgeList);

        parent = new int[N + 1];
        makeParent();

        int count = 0;
        for(Edge edge : edgeList){
            if(!union(edge.from, edge.to)) continue;
            sum += edge.weight;
            count++;
            if(count > N - 1) break;
        }

        System.out.println(sum);
        br.close();
    }
}