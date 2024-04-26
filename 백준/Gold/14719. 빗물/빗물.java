import java.util.*;

public class Main {

    static int h, w;
    static int[] height;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        h = scan.nextInt();
        w = scan.nextInt();

        height = new int[w];
        for(int i = 0; i < w; i++) {
            height[i] = scan.nextInt();
        }

        int result = 0;
        for(int i = 0; i < w; i++) { // 루프 시작점 변경
            int leftMax = 0;
            int rightMax = 0;

            // 현재 봉우리에서 왼쪽으로 가면서 최대 높이 찾기
            for(int j = i; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }

            // 현재 봉우리에서 오른쪽으로 가면서 최대 높이 찾기
            for(int j = i; j < w; j++) {
                rightMax = Math.max(height[j], rightMax);
            }

            // 빗물이 고이는 부분 계산
            int minMax = Math.min(leftMax, rightMax);
            if(minMax > height[i]) { // 현재 봉우리의 높이보다 최대 높이가 더 높을 때
                result += minMax - height[i]; // 빗물이 고이는 부분 계산
            }
        }
        System.out.println(result);
    }
}