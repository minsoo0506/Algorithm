import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int arr[] = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] != 1 && isPrime(arr[i])){
                count++;
            }
        }

        System.out.println(count);
        scan.close();
    }

    public static boolean isPrime(int n){
        boolean result = true;

        for(int i = 2; i < n; i++){
            if(n % i == 0){
                result = false;
            }
        }

        return result;
    }
}