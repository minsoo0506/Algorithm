import java.util.Scanner;

public class Main {
    public static int recursion(int n, int r){
        if(r == 0 || n == r){
            return 1;
        }
        else{
            return recursion(n - 1, r - 1) + recursion(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        System.out.println(recursion(N, K));
        scan.close();
    }
}