import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] edgeCount;
    private static ArrayList<Integer>[] graph;

    public static String topologicalSort(){
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 1; i <= N; i++){
            if(edgeCount[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int nodeNo = queue.poll();
            sb.append(nodeNo).append(" ");

            for(int i : graph[nodeNo]){
                edgeCount[i]--;
                if(edgeCount[i] == 0){
                    queue.offer(i);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeCount = new int[N + 1];
        graph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            edgeCount[B]++;
            graph[A].add(B);
        }

        System.out.println(topologicalSort());
    }
}