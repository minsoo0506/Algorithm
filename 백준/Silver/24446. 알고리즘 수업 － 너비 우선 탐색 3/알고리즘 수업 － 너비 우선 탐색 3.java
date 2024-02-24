import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static int[] depth;

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visit[start] = true;
        depth[start] += 1;

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i = 0; i < graph.get(temp).size(); i++){
                int nextV = graph.get(temp).get(i);

                if(!visit[nextV]) {
                    q.offer(nextV);
                    visit[nextV] = true;
                    depth[nextV] = depth[temp] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        depth = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            depth[i] = -1;
        }


        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs(R);

        for(int i = 1; i <= N; i++)
            System.out.println(depth[i]);
    }
}