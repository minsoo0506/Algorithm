import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int count = 0;
        int value[] = new int[N];

        for(int i = 0; i < N; i++){
            value[i] = scan.nextInt();
        }

        for(int i = N - 1; i >= 0; i--){
            while(K >= value[i]){
                K -= value[i];
                count++;
            }
        }
        System.out.println(count);
    }
}