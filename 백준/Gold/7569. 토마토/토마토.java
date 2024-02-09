import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int floor;
    int x;
    int y;

    public Point(int floor, int x, int y) {
        this.floor = floor;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int M, N, H;
    static int[][][] box;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static boolean checkPoint(int floor, int x, int y) {
        if(floor >= 0 && floor < H && x >= 0 && x < N && y >= 0 && y < M){
            if(box[floor][x][y] == 0){
                return true;
            }
        }

        return false;
    }
    public static int bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int floor = point.floor;
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 6; i++) {
                int nextFloor = floor + dz[i];
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(checkPoint(nextFloor, nextX, nextY)){
                    queue.add(new Point(nextFloor, nextX, nextY));
                    box[nextFloor][nextX][nextY] = box[floor][x][y] + 1;
                }
            }
        }

        int day = 0;

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(box[i][j][k] == 0) return -1;
                    day = Math.max(day, box[i][j][k]);
                }
            }
        }

        return day == 1 ? 0 : day - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.offer(new Point(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }
}