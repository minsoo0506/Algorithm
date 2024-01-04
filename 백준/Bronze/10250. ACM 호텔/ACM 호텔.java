import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        int room[] = new int[T];

        for(int i = 0; i < T; i++){
            int H = scan.nextInt();
            int W = scan.nextInt();
            int N = scan.nextInt();

            int floor = (N % H == 0) ? H : N % H;
            int th = (N - 1) / H + 1;
            room[i] = floor * 100 + th;
        }

        for(int i = 0; i < T; i++){
            System.out.println(room[i]);
        }

        scan.close();
    }
}