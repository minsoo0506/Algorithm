import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = 1;
        int[] digit = new int[10];

        for(int i = 0; i < 3; i++){
            int num = scan.nextInt();
            n *= num;
        }

        String s = Integer.toString(n);

        for(int i = 0; i < s.length(); i++){
            int d = s.charAt(i) - '0';
            digit[d]++;
        }

        for(int i = 0; i < digit.length; i++){
            System.out.println(digit[i]);
        }

        scan.close();
    }
}