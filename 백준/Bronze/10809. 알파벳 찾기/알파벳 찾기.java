import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        boolean[] visit = new boolean[26];
        String str = scan.nextLine();

        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            if(visit[index] == false){
                arr[index] = i;
                visit[index] = true;
            }

        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        scan.close();
    }
}