import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

// 좌표를 저장하는 클래스
class Point{
    public int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int M, N, K;// 가로, 세로, 배추가 심어져 있는 위치의 개수
    public static int[][] arr;// 배추밭의 정보를 담은 이차원 배열

    // bfs 탐색을 수행하는 메소드
    public static int bfs(){
        Queue<Point> queue = new LinkedList<>();// 1이면서 방문하지 않은 좌표를 저장하는 큐
        boolean[][] visited = new boolean[M][N];// 방문 여부를 저장하는 배열
        int count = 0;// 배추밭에 필요한 배추흰지렁이의 개수

        // 우, 상, 좌, 우
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 배추밭 전체를 돌며 필요한 배추흰지렁이 개수 구하기
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                // 좌표값이 0이거나 1이지만 방문한 곳이라면 건너뛰기
                if(arr[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                count++;// 좌표값이 1이면서 방문한 곳이 아니기 때문에 필요한 지렁이 개수 +1
                queue.offer(new Point(i, j));// 큐에 넣기
                visited[i][j] = true;// 방문 처리

                // 큐가 비어 있을 때까지 반복 수행
                while(!queue.isEmpty()){
                    // 큐의 첫번째 값을 불러옴
                    Point temp = queue.poll();

                    // 우, 상, 좌, 하를 순차적으로 탐색
                    for(int k = 0; k < 4; k++){
                        // 새로운 좌표 값
                        int nx = temp.x + dx[k];
                        int ny = temp.y + dy[k];
                        // 새로운 좌표 값이 범위 내에 있으며, 1임과 동시에 방문하지 않았다면 수행
                        if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                            if(arr[nx][ny] == 1 && !visited[nx][ny]){
                                visited[nx][ny] = true;// 방문 처리
                                queue.offer(new Point(nx, ny));// 해당 좌표 큐에 넣기
                            }
                        }
                    }
                }
            }
        }

        return count;// 필요한 지렁이의 개수 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        // 테스트 케이스의 개수만큼 반복문 돌기
        for(int i = 0; i < T; i++){
            // 사용자 입력 읽어들이기
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];

            // 배추가 심어져 있는 땅 1로 표시
            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
            }

            // bfs 탐색 이후 필요한 최소의 배추흰지렁이 개수 sb에 붙이기
            sb.append(bfs()).append("\n");
        }

        // sb 출력
        System.out.print(sb);
    }
}