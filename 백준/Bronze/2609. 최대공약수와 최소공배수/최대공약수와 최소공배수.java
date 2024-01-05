import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b){
        int min = Math.min(a, b);
        int result = 0;

        for(int i = min; i >= 0; i--){
            if(a % i == 0 && b % i == 0){
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        System.out.println(gcd(a, b));
        System.out.println(a * b / gcd(a, b));

        scan.close();
    }
}