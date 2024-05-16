import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edgeCount = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int sequence = Integer.parseInt(st.nextToken());

            int prev = 0;
            int now = 0;
            for(int j = 0; j < sequence; j++){
                if(j == 0) {
                    prev = Integer.parseInt(st.nextToken());
                } else {
                    now = Integer.parseInt(st.nextToken());

                    graph[prev].add(now);
                    edgeCount[now]++;

                    prev = now;
                }
            }
        }

        // 위상 정렬에 사용할 큐
        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수가 0인 값 큐에 넣기
        for(int i = 1; i < edgeCount.length; i++){
            if(edgeCount[i] == 0){
                queue.offer(i);
            }
        }

        int visitCount = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 큐에서 노드 번호 꺼내기
            int singer = queue.poll();
            visitCount++;

            // 꺼낸 노드 번호 정렬 결과값에 저장
            bw.write(String.valueOf(singer) + "\n");

            // 꺼낸 노드의 인접한 노드들 찾기
            List<Integer> list = graph[singer];

            // 인접한 노드의 개수만큼 반복문 실행
            for(int i = 0; i < list.size(); i++){
                // 인접한 노드 진입 차수 갱신
                edgeCount[list.get(i)]--;
                // 갱신된 노드의 진입 차수가 0이면 큐에 노드 넣기
                if(edgeCount[list.get(i)] == 0){
                    queue.offer(list.get(i));
                }
            }
        }
        
        // 사이클이 발생하여 모든 노드를 방문할 수 없는 경우 0을 출력
        if(visitCount < N){
            System.out.println(0);
        } else {
            bw.flush();
        }
    }
}