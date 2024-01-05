import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int min = Integer.MAX_VALUE;

        for(int i = n; i >= 0; i--){
            char[] ch = Integer.toString(i).toCharArray();
            int sum = i;
            for(int j = 0; j < ch.length; j++){
                sum += (ch[j] - '0');
            }
            if(sum == n && i < min){
                min = i;
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(0);
        }
        else {
            System.out.println(min);
        }
        scan.close();
    }
}