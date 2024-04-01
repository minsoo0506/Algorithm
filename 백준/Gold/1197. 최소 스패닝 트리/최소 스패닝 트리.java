// MST - Kruskal 알고리즘 : O(ElogE)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

// 간선에 대한 정보를 담는 클래스
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
    // 정점의 개수, 간선의 개수, 가중치의 합
    private static int V, E, sum;
    private static int[] parent; // 부모 노드의 인덱스 저장
    private static Edge[] edgeList; // 간선 리스트

    // 부모 노드를 자기 자신으로 설정하는 메소드
    public static void makeParent(){
        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }
    }

    // 부모 노드를 확인하는 메소드
    public static int find(int x){
        return (x == parent[x]) ? x : (parent[x] = find(parent[x]));
    }

    // 사이클이 발생하지 않는다면 연결시켜주는 메소드
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edgeList = new Edge[E];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeList); // 간선 리스트 오름차순 정렬

        // Union-find
        parent = new int[V + 1];
        makeParent(); // 부모 노드를 자기 자신으로 설정

        // 가중치가 낮은 간선부터 선택하면서 트리를 형성
        // 사이클이 존재하면 남아 있는 간선 중 그 다음으로 가중치가 낮은 간선 선택

        int count = 0;
        for(Edge edge : edgeList){
            if(!union(edge.from, edge.to)) continue;
            sum += edge.weight;
            count++;
            if(count > V - 1) break;
        }

        System.out.println(sum);
        br.close();
    }
}