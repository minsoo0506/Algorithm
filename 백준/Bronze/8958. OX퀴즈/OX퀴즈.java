import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int result = 0;
            int count = 0;
            char[] ch = scan.nextLine().toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == 'O') {
                    count++;
                    result += count;
                }
                if (ch[j] == 'X') {
                    count = 0;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
        scan.close();
    }
}