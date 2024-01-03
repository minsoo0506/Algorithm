import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++){
            arr[i] = scan.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for(int i = 0; i < 9; i++){
            if(max < arr[i]){
                max = arr[i];
                max_index = i;
            }
        }

        System.out.println(max);
        System.out.println(max_index + 1);

        scan.close();
    }
}