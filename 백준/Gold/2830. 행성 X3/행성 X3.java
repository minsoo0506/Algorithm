import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int bin_digit[] = new int[20];
        int num, tmp = 0;
        int index;
        long result = 0L;

        for(int i = 0; i < N; i++){
           index = 0;
           num = scan.nextInt();
           while(num > 0){
               tmp = num % 2;
               num /= 2;
               if(tmp == 1){
                   bin_digit[index]++;
               }
               index++;
           }
        }

        for(int i = 0; i < 20; i++){
            result += (1L << i) * bin_digit[i] * (N - bin_digit[i]);
        }

        System.out.println(result);
    }
}