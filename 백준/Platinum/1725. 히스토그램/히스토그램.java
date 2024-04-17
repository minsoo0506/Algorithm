// 백준 1725 히스토그램
// 스택으로 풀이(브루트포스로는 시간초과)
import java.io.*;
import java.util.Stack;

public class Main {
    // 배열이 주어졌을 때 히스토그램에서 가장 큰 면적을 반환하는 메소드
    public static long getMaxArea(long[] heights){
        long maxArea = 0; // 가능한 최대 사각형의 면적을 저장할 변수
        Stack<Integer> stack = new Stack<>(); // 높이가 증가하는 순서로 인덱스를 저장할 스택

        // 배열 순회하며 스택에 인덱스 쌓기
        for(int i = 0; i < heights.length; i++){
            // 스택의 맨 위에 있는 요소의 높이가 현재 요소의 높이보다 크면, 스택에서 요소를 꺼내고
            // 해당 요소의 높이와 가장 넓은 너비를 사용하여 가능한 최대 사각형의 면적을 계산한다.
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                long height = heights[stack.pop()];
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i); // 현재 인덱스를 스택에 쌓는다.
        }

        // 배열의 모든 요소를 순회한 후에 스택에 남아 있는 모든 요소를 꺼내고,
        // 각 요소에 대해 가능한 최대 사각형의 면적을 계산한다.
        while(!stack.isEmpty()){
            long height = heights[stack.pop()];
            long width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea; // 최대 사각형의 면적 반환
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] heights = new long[n];

        for(int i = 0; i < n; i++){
            heights[i] = Long.parseLong(br.readLine());
        }

        // getMaxArea 메소드 실행결과 출력
        System.out.println(getMaxArea(heights));
    }
}