// 백준 17386 선분 교차1
// CCW 알고리즘 사용
import java.io.*;
import java.util.*;

// 점에 대한 정보를 담는 클래스
class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static Point[] point;

    // 외적 계산을 통해 세 점이 CW, CCW, 일직선 중에 어디에 해당하는지 판별
    // (x2-x1)(y3-y1) - (x3-x1)(y2-y1) = x1y2 + x2y3 + x3y1 - (y1x2 + y2x3 + y3x1)
    public static int ccw(Point p1, Point p2, Point p3){
        long result = (long)(p2.x - p1.x) * (p3.y - p1.y) - (long)(p3.x - p1.x) * (p2.y - p1.y);

        if(result > 0) return 1;
        else if(result < 0) return -1;
        else return 0;
    }

    public static boolean isIntersect(Point a, Point b, Point c, Point d){
        // 선분 ab를 기준으로 점 c와 d가 CW, CCW, 일직선 상인지 판별
        // ccw(a, b, c)와 ccw(a, b, d) 결과 모두 1이거나 -1이면 서로 곱하였을 때 1이 되므로 교차 X
        int l1 = ccw(a, b, c) * ccw(a, b, d);
        // 선분 cd를 기준으로 점 a와 b가 CW, CCW, 일직선 상인지 판별
        // 선분 ab를 기준으로만 하면 l1의 결과가 0이하임에도 불구하고 교차하지 않는 반례가 있으므로, 기준 선분을 cd로 바꾸어 계산해보기
        int l2 = ccw(c, d, a) * ccw(c, d, b);

        return l1 <= 0 && l2 <= 0;
    }

    public static void main(String[] args) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        point = new Point[4];

        for(int i = 0; i < 4; i+=2){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            point[i] = new Point(x1, y1);
            point[i + 1] = new Point(x2, y2);
        }

        // 선분 교차 판별 및 결과 출력
        System.out.println(isIntersect(point[0], point[1], point[2], point[3]) ? 1 : 0);
    }
}