import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        int count = 1;

        q.offer(start);
        visited[start] = count++;

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i = 0; i < graph.get(temp).size(); i++){
                int nextV = graph.get(temp).get(i);

                if(visited[nextV] != 0)
                    continue;

                q.offer(nextV);
                visited[nextV] = count++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        for(int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 1; i <= N; i++)
            Collections.sort(graph.get(i), Collections.reverseOrder());

        bfs(R);

        for(int i = 1; i <= N; i++)
            System.out.println(visited[i]);
    }
}