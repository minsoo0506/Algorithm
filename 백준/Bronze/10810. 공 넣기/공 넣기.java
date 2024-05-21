import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] baskets = new int[N + 1];

        for (int m = 0; m < M; m++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int k = scanner.nextInt();
            for (int index = i; index <= j; index++) {
                baskets[index] = k;
            }
        }

        for (int n = 1; n <= N; n++) {
            System.out.print(baskets[n] + " ");
        }
    }
}