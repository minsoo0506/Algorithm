// 백준 11758 CCW
// Counter Clock Wise : 3개의 점 A, B, C가 있을 때, 점 3개를 이은 직선의 방향을 알고자 할 때 사용하는 기하 알고리즘
// 경우의 수는 총 3가지로 시계, 반시계, 직선이 있으며 벡터의 외적을 통하여 구한다.
// 외적의 결과가 음수면 시계 방향, 0이면 직선, 양수일 경우 반시계 방향이다.
import java.io.*;
import java.util.*;

// 점의 좌표에 대한 정보를 담는 Point 클래스
class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int ccw(Point[] points){
        // 두 벡터의 외적 계산(수직 벡터 값)
        int result = points[0].x * points[1].y + points[1].x * points[2].y + points[2].x * points[0].y;
        result -= points[1].x * points[0].y + points[2].x * points[1].y + points[0].x * points[2].y;

        // 두 벡터의 수직 벡터 값에 따라 결과값 리턴
        if(result > 0) return 1;
        else if(result == 0) return 0;
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Point[] points = new Point[3];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        System.out.println(ccw(points));
    }
}