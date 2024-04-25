import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] edgeCount;
    private static int[][] dag;
    private static int[] partCount;
    private static boolean[] isComb;

    public static void topologicalSort(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(edgeCount[i] == 0){
                queue.offer(i);
                partCount[i] = 1;
            }
        }

        while(!queue.isEmpty()){
            int nodeNo = queue.poll();

            for(int i = 1; i <= N; i++){
                if(dag[nodeNo][i] != 0){
                    partCount[i] += partCount[nodeNo] * dag[nodeNo][i];
                    edgeCount[i]--;

                    if(edgeCount[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edgeCount = new int[N + 1];
        dag = new int[N + 1][N + 1];
        partCount = new int[N + 1];
        isComb = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            dag[X][Y] = K; // 그래프를 저장함과 동시에, 필요한 부품 수까지 저장
            edgeCount[Y]++; // in-degree 값을 거꾸로 저장 : out-degree
            isComb[X] = true; // 중간 부품이나 완제품에 해당함
        }

        topologicalSort(); // 위상 정렬 수행

        for(int i = 1; i <= N; i++){
            // 기본 부품의 개수만 출력
            if(!isComb[i]){
                System.out.println(i + " " + partCount[i]);
            }
        }
    }
}