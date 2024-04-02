// 백준 2887 행성 터널
// 최소 신장 트리 : 크루스칼 알고리즘으로 풀이
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 행성에 대한 정보를 담는 클래스
class Planet{
    int id; // 행성의 노드 번호
    int x;
    int y;
    int z;

    public Planet(int id, int x, int y, int z){
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

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

    // 간선의 가중치를 비교
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    private static int N, sum;
    private static int[] parent;
    private static Planet[] planets;

    // 행성 간의 거리를 계산하는 메소드
    public static int calculateCost(Planet p1, Planet p2) {
        int dx = Math.abs(p1.x - p2.x);
        int dy = Math.abs(p1.y - p2.y);
        int dz = Math.abs(p1.z - p2.z);

        return Math.min(dx, Math.min(dy, dz));
    }

    // 기본 부모 노드를 자기 자신으로 설정하는 메소드
    public static void makeParent(){
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
    }

    // 부모 노드를 탐색하는 메소드
    public static int find(int a){
        return (a == parent[a]) ? a : (parent[a] = find(parent[a]));
    }

    // 부모 노드가 다르다면 b노드의 부모를 a노드로 설정하는 메소드
    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;
        else {
            parent[b] = a;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사용자 입력
        N = Integer.parseInt(br.readLine());
        planets = new Planet[N + 1];
        parent = new int[N + 1];
        PriorityQueue<Edge> edges = new PriorityQueue<>();

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i] = new Planet(i, x, y, z);
        }

        makeParent();

        /*
        * 모든 간선을 저장하면 N * (N-1) 개의 간선이 저장되므로 메모리 초과 발생
        * 메모리 초과를 막기 위해 x, y, z 각각의 축별로 비교해서 우선순위 큐에 저장
        * (굳이 비용이 큰 간선을 저장하지 않는 것)
        * 간선의 수가 최대 N * (N-1)개에서 3 * (N-1)개로 줄어듦
        * 하지만 그리디 알고리즘이 들어가 있으므로 항상 최적의 해를 보장하지는 않음
        */
        Arrays.sort(planets, 1, N + 1, (p1, p2) -> p1.x - p2.x);
        for(int i = 1; i < N; i++) {
            edges.offer(new Edge(planets[i].id, planets[i + 1].id, calculateCost(planets[i], planets[i + 1])));
        }

        Arrays.sort(planets, 1, N + 1, (p1, p2) -> p1.y - p2.y);
        for(int i = 1; i < N; i++) {
            edges.offer(new Edge(planets[i].id, planets[i + 1].id, calculateCost(planets[i], planets[i + 1])));
        }

        Arrays.sort(planets, 1, N + 1, (p1, p2) -> p1.z - p2.z);
        for(int i = 1; i < N; i++) {
            edges.offer(new Edge(planets[i].id, planets[i + 1].id, calculateCost(planets[i], planets[i + 1])));
        }

        // Union-find
        // Union : 두 개의 서로소 집합을 하나의 집합으로 합치기(두 집합이 동일한 집합에 속해 있는지를 확인)
        // find : 주어진 원소가 어떤 집합에 속해 있는지를 찾기(주어진 원소의 '루트(부모)'를 찾는 데 사용)
        while(!edges.isEmpty()){
            Edge edge = edges.poll();
            if(union(edge.from, edge.to)){
                sum += edge.weight;
            }
        }

        System.out.println(sum);
        br.close();
    }
}
