import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int A = scan.nextInt();
        int H = scan.nextInt();
        long result = 1;

        for(int i = 1; i <= N - 1; i++){
            result = (result * M) % 1000000007;
        }

        System.out.println(result);
    }
}