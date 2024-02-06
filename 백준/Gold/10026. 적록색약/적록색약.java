import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static char[][] arr;
    static boolean[][] visit;

    public static int bfs(char color, boolean colorBlind){
        visit = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        int count = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        if(colorBlind){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == 'B' || visit[i][j]) continue;

                    count++;
                    visit[i][j] = true;
                    queue.offer(new Point(i, j));

                    while(!queue.isEmpty()){
                        Point temp = queue.poll();

                        for(int k = 0; k < 4; k++){
                            int nx = temp.x + dx[k];
                            int ny = temp.y + dy[k];
                            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                                if(arr[nx][ny] != 'B' && !visit[nx][ny]){
                                    visit[nx][ny] = true;
                                    queue.offer(new Point(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] != color || visit[i][j]) continue;

                    count++;
                    visit[i][j] = true;
                    queue.offer(new Point(i, j));

                    while(!queue.isEmpty()){
                        Point temp = queue.poll();

                        for(int k = 0; k < 4; k++){
                            int nx = temp.x + dx[k];
                            int ny = temp.y + dy[k];
                            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                                if(arr[nx][ny] == color && !visit[nx][ny]){
                                    visit[nx][ny] = true;
                                    queue.offer(new Point(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    public static int RGColorBlind(){
        return bfs('R', true) + bfs('B', false);
    }
    public static int notColorBlind(){
        return bfs('R', false) + bfs('G', false) + bfs('B', false);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                arr[i][j] = line.charAt(j);
            }
        }

        System.out.println(notColorBlind() + " " + RGColorBlind());
    }
}