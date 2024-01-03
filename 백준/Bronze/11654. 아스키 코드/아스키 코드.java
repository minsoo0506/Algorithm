import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        System.out.println((int)s.charAt(0));
        scan.close();
    }
}