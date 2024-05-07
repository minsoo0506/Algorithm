// 백준 2146 다리 만들기
// BFS와 DFS 사용하여 풀이
import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    int cost;

    public Point(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class Main {
    private static int N;
    private static int[][] map;
    private static boolean[][] visit;
    private static int minBridgeLength;

    // 우,상,좌,하
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    // 새로운 x, y 좌표가 이차원 배열 내에 위치하는지 확인하는 메소드
    public static boolean rangeCheck(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    // 각각의 좌표가 섬(1)인지 확인 후, 좌표에 섬의 번호 부여
    public static void dfs(int x, int y, int id){
        visit[x][y] = true;
        map[x][y] = id;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(rangeCheck(nx, ny) && map[nx][ny] == 1 && !visit[nx][ny]){
                dfs(nx, ny, id);
            }
        }
    }

    public static int bfs(int id){
        Queue<Point> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // (i, j)가 id번 째 섬에 해당한다면 큐에 저장
                if(map[i][j] == id){
                    visit[i][j] = true;
                    queue.offer(new Point(i, j, 0));
                }
            }
        }

        int minlength = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Point cur = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(rangeCheck(nx, ny)){
                    // 이동한 좌표가 육지이면서 다른 번호를 가진 섬이라면,
                    // 해당 섬까지의 거리와 minlength를 비교하여 더 작은 값을 저장
                    if(map[nx][ny] != 0 && map[nx][ny] != id){
                        minlength = Math.min(minlength, cur.cost);
                    } 
                    // 이동한 좌표가 바다라면 이전까지의 cost에 1을 더하여 큐에 저장
                    else if(map[nx][ny] == 0 && !visit[nx][ny]){
                        visit[nx][ny] = true;
                        queue.offer(new Point(nx, ny, cur.cost + 1));
                    }
                }
            }
        }

        return minlength;
    }

    public static void main(String[] args) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // map[i][j]가 1이라면 섬의 번호(id) 부여(저장)
        int id = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visit[i][j]){
                    dfs(i, j, id++);
                }
            }
        }

        minBridgeLength = Integer.MAX_VALUE;
        for(int i = 1; i < id; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(visit[j], false);
            }
            minBridgeLength = Math.min(minBridgeLength, bfs(i));
        }

        System.out.println(minBridgeLength);
    }
}
