import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        int arr[] = new int[8];
        for(int i = 0; i < 8; i++){
            arr[i] = scan.nextInt();
        }

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] >= arr[i + 1]){
                flag = false;
            }
        }
        if(flag == true) {
            System.out.println("ascending");
            return;
        }

        flag = true;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] <= arr[i + 1]){
                flag = false;
                System.out.println("mixed");
                return;
            }
        }
        if(flag == true) {
            System.out.println("descending");
        }

        scan.close();
    }
}