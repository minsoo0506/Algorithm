import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] firstPrize = {500, 300, 200, 50, 30, 10};
        int[] secondPrize = {512, 256, 128, 64, 32};
        
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int prize = 0;

            if (a > 0 && a <= 21) {
                for (int j = 0; j < firstPrize.length; j++) {
                    a -= j+1;
                    if (a <= 0) {
                        prize += firstPrize[j];
                        break;
                    }
                }
            }

            if (b > 0 && b <= 31) {
                for (int j = 0; j < secondPrize.length; j++) {
                    b -= Math.pow(2, j);
                    if (b <= 0) {
                        prize += secondPrize[j];
                        break;
                    }
                }
            }

            System.out.println(prize * 10000);
        }
        sc.close();
    }
}