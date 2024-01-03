import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int sum = 0;

        String s = scan.nextLine().trim();
        char[] ch = s.toCharArray();

        for(int i = 0; i < N; i++){
            sum += Character.getNumericValue(ch[i]);
        }

        System.out.println(sum);
    }
}