import java.util.*;

class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

class Main{
    public static void main(String[] args){
        //사용자 입력 및 변수 선언
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();
        int[][]arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = scan.nextInt();
            }
        }
        boolean[][] visit = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> queue = new LinkedList<>();

        //이차원 배열 탐색
        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //배열 요소가 0이거나 이미 방문한 곳이라면 continue
                if(arr[i][j] == 0 || visit[i][j] == true){
                    continue;
                }
                else{
                    int area = 0;
                    count++;//그림의 개수 +1
                    visit[i][j] = true;//해당 요소 방문 처리
                    queue.offer(new Point(i, j));//큐에 해당 요소 넣기
                    //큐가 비어있을 때까지 반복
                    while(!queue.isEmpty()){
                        area++;//그림의 넓이 +1
                        Point p = queue.poll();
                        // 우, 상, 좌, 하 순으로 인접해있는 1을 탐색한다.(방문하지 않은 1)
                        for(int k = 0; k < 4; k++){
                            int tempX = p.getX() + dx[k];
                            int tempY = p.getY() + dy[k];
                            // 인접하는 곳이 범위를 넘어가는 곳이라면 break
                            if(tempX < 0 || tempY < 0 || tempX >= n || tempY >= m) {
                                continue;
                            }
                            // 배열의 요소가 1이면서 방문하지 않은 곳이라면 방문 처리 후 큐에 넣기
                            if(arr[tempX][tempY] == 1 && visit[tempX][tempY] == false){
                                visit[tempX][tempY] = true;
                                queue.offer(new Point(tempX, tempY));
                            }
                        }
                    }
                    // 그림의 넓이 최댓값 갱신
                    if(area > max){
                        max = area;
                    }
                }
            }
        }

        //출력
        System.out.println(count);
        System.out.println(max);

        scan.close();
    }
}