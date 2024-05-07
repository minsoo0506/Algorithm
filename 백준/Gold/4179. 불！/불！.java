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
    private static int R, C;
    private static char[][] maze;
    private static boolean[][] visit;

    // 우,상,좌,하
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    // 새로운 x, y 좌표가 이차원 배열 내에 위치하는지 확인하는 메소드
    public static boolean rangeCheck(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static int bfs(Queue<Point> fireQueue, Queue<Point> jihunQueue){
        while(!jihunQueue.isEmpty()){
            int fireSize = fireQueue.size();
            for(int i = 0; i < fireSize; i++){
                Point fire = fireQueue.poll();

                for(int j = 0; j < 4; j++){
                    int nx = fire.x + dx[j];
                    int ny = fire.y + dy[j];

                    if(rangeCheck(nx, ny) && maze[nx][ny] != '#' && maze[nx][ny] != 'F'){
                        maze[nx][ny] = 'F';
                        fireQueue.offer(new Point(nx, ny, 0));
                    }
                }
            }

            int jihunSize = jihunQueue.size();
            for(int i = 0; i < jihunSize; i++){
                Point jihun = jihunQueue.poll();

                for(int j = 0; j < 4; j++){
                    int nx = jihun.x + dx[j];
                    int ny = jihun.y + dy[j];

                    if(!rangeCheck(nx, ny)){
                        return jihun.cost;
                    }

                    if(!visit[nx][ny] && maze[nx][ny] == '.'){
                        visit[nx][ny] = true;
                        jihunQueue.offer(new Point(nx, ny, jihun.cost + 1));
                    }
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new char[R][C];
        visit = new boolean[R][C];

        int startX = 0;
        int startY = 0;
        Queue<Point> jihunQueue = new LinkedList<>();
        Queue<Point> fireQueue = new LinkedList<>();
        for(int i = 0; i < R; i++){
            String lineInput = br.readLine();
            for(int j = 0; j < C; j++){
                maze[i][j] = lineInput.charAt(j);
                if(maze[i][j] == 'J'){
                    startX = i;
                    startY = j;
                }
                else if(maze[i][j] == 'F'){
                    fireQueue.offer(new Point(i, j, 0));
                }
            }
        }

        jihunQueue.offer(new Point(startX, startY, 1));
        int result = bfs(fireQueue, jihunQueue);
        if(result == -1){
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }
}