import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][][] dist; // 각 위치에 도달하는 데 필요한 최소 이동 횟수를 저장하는 배열. dist[x][y][0]은 벽을 부수지 않고 (x, y)에 도달하는 데 필요한 이동 횟수, dist[x][y][1]은 벽을 부수고 (x, y)에 도달하는 데 필요한 이동 횟수를 저장.
    private static int[][] map; // 그래프 정보를 저장하는 배열. map[x][y]는 (x, y) 위치의 상태를 나타냄. 0은 이동할 수 있는 곳, 1은 벽을 의미.
    private static int[] dx = {-1, 0, 1, 0}; // x 방향 이동을 위한 배열(좌, 상, 우, 하)
    private static int[] dy = {0, 1, 0, -1}; // y 방향 이동을 위한 배열(좌, 상, 우, 하)
    private static int N, M; // 그래프의 크기

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // 시작 위치와 벽을 부순 횟수를 큐에 추가
        dist[0][0][0] = 1; // 시작 위치의 이동 횟수를 1로 설정

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i]; // 다음 칸의 x좌표
                int ny = cur[1] + dy[i]; // 다음 칸의 y좌표
                int block = cur[2]; // 벽을 부순 횟수(한번이 최대)

                // 다음 칸이 맵의 범위를 벗어난다면 continue
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 이미 방문한 칸이라면 continue
                if(dist[nx][ny][block] != -1) continue;

                if(map[nx][ny] == 0){ // 이동할 수 있는 곳이라면
                    dist[nx][ny][block] = dist[cur[0]][cur[1]][block] + 1; // 이동 횟수 갱신
                    queue.add(new int[]{nx, ny, block}); // 큐에 다음 칸의 정보와 벽을 부순 횟수 추가
                } else if(map[nx][ny] == 1 && block == 0){ // 이동할 수 없지만 벽을 한번도 부수지 않았다면
                    dist[nx][ny][1] = dist[cur[0]][cur[1]][block] + 1; // 벽을 부수고 이동한 경우의 이동 횟수를 갱신
                    queue.add(new int[]{nx, ny, 1}); // 벽을 부수고 이동한 경우를 큐에 추가
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사용자 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][2];

        // map 생성
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
                Arrays.fill(dist[i][j], -1);
            }
        }

        // bfs 수행
        bfs();

        // 벽을 부수든 부수지 않든 마지막 위치에 도달할 수 없다면 -1 출력
        if (dist[N - 1][M - 1][0] == -1 && dist[N - 1][M - 1][1] == -1){
            System.out.println(-1);
        }
        // 벽을 부숴야 마지막 위치에 도달 할 수 있다면
        else if (dist[N - 1][M - 1][0] == -1){
            System.out.println(dist[N - 1][M - 1][1]); // 벽을 부수고 마지막 위치에 도달했을 때의 이동 횟수 출력
        }
        // 벽을 부수지 않아도 마지막 위치에 도달 할 수 있다면
        else if (dist[N - 1][M - 1][1] == -1){
            System.out.println(dist[N - 1][M - 1][0]); // 벽을 부수지 않고 마지막 위치에 도달했을 때의 이동 횟수 출력
        }
        // 벽을 부수든 부수지 않든 마지막 위치에 도달 할 수 있다면 둘(이동 횟수) 중 최솟값 출력
        else {
            System.out.println(Math.min(dist[N - 1][M - 1][0], dist[N - 1][M - 1][1]));
        }
    }
}