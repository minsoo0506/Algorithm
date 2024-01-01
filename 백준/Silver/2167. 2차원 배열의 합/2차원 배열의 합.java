import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        scan.nextLine();
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = scan.nextInt();
            }
            scan.nextLine();
        }

        int K = scan.nextInt();
        int[] result = new int[K];
        for(int k = 0; k < K; k++){
            int sum = 0;
            int i = scan.nextInt() - 1;
            int j = scan.nextInt() - 1;
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;
            //scan.nextLine();
            for(int row = i; row <= x; row++){
                for(int col = j; col <= y; col++){
                    sum += arr[row][col];
                }
            }
            result[k] = sum;
        }

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

        scan.close();
    }
}