import java.util.Scanner;

public class Main {
    public static boolean isPalindrome(String s){
        boolean result = true;
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                result = false;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(!isPalindrome(str.substring(i))){
                count++;
            }
            else{
                break;
            }
        }

        System.out.println(str.length() + count);
        scan.close();
    }
}