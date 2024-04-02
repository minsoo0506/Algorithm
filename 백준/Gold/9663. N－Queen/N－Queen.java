// N-Queen 문제
// 재귀를 통한 백트래킹으로 풀이
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int N;
    public static int count; // 퀸을 놓는 방법의 수
    public static int[] board; // 퀸을 놓는 배열(판), 체스판

    public static boolean checkQueen(int row){
        for(int i = 0; i < row; i++){
            // row 값은 행, board[row] 값은 열을 나타냄
            if(board[row] == board[i]){
                return false;
            } else if(Math.abs(row - i) == Math.abs(board[row] - board[i])){
                return false;
            }
        }

        // 새로운 퀸을 놓을 수 있는 자리가 비어있는 행이면서 이전 퀸에 대해 대각선이 아니라면 true 반환
        return true;
    }

    public static void backTracking(int queenCount){
        // N개 만큼 퀸을 놓았다면 count+1
        if(queenCount == N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            board[queenCount] = i;
            // 새로운 퀸을 놓을 수 있는 위치라면 재귀 호출을 통해 퀸을 놓는다
            if(checkQueen(queenCount)){
                backTracking(queenCount + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N];
        count = 0;

        backTracking(0);
        System.out.println(count);
    }
}