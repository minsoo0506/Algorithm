// 백준 2252 줄 세우기 : 위상 정렬(Topological Sort)
// 선후관계가 정의된 그래프 구조(Directed Acyclic Graph)에서 정렬 하기
// 큐, 스택, 재귀를 사용하여 풀이 가능
// 그래프에 사이클이 있거나, 진입 차수가 0인 노드가 없다면 불가능
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M; // 학생 수, 키를 비교한 횟수
    private static int[] edgeCount; // 위상 정렬에 사용할 진입차수 저장 배열
    private static ArrayList<Integer>[] graph;// 위성 정렬에 사용할 그래프

    // In-degree(특정 노드에 대해서 다른 노드로부터 들어오는 간선의 개수) 방법
    public static String bfs(){
        StringBuilder sb = new StringBuilder(); // 위상 정렬 결과를 저장할 객체
        Queue<Integer> queue = new LinkedList<>(); // 위상 정렬에 사용할 큐

        // 진입 차수가 0인 값 큐에 넣기
        for(int i = 1; i <= N; i++){
            if(edgeCount[i] == 0){
                queue.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 큐에서 노드 번호 꺼내기
            int nodeNo = queue.poll();
            // 꺼낸 노드 번호 정렬 결과값에 저장
            sb.append(nodeNo).append(" ");

            // 인접한 노드의 개수만큼 반복문 실행
            for(int i : graph[nodeNo]){
                // 인접한 노드 진입차수 갱신
                edgeCount[i]--;
                // 갱신된 노드의 진입차수가 0이면 큐에 노드 넣기
                if(edgeCount[i] == 0){
                    queue.offer(i);
                }
            }
        }

        return sb.toString(); // 위상 정렬 수행 결과 값 반환
    }

    public static void main(String args[]) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 크기 선언
        edgeCount = new int[N + 1];
        graph = new ArrayList[N + 1];

        // ArrayList 배열 각각에 메모리 할당
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        // 진입차수 테이블 초기화
        // 그래프 각 노드별 인접한 노드 정보 초기화
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            edgeCount[B]++;
            graph[A].add(B);
        }

        // 위상 정렬 수행 결과 값 출력
        System.out.println(bfs());
    }
}