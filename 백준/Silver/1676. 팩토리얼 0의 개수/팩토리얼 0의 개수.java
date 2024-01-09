import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        BigInteger bigInt = new BigInteger("1");
        for(int i = 1; i <= N; i++){
            bigInt = bigInt.multiply(BigInteger.valueOf(i));
        }
        char[] charArr = bigInt.toString().toCharArray();

        int count = 0;
        for(int i = charArr.length - 1; i >= 0; i--){
            if(charArr[i] != '0'){
                break;
            }
            else{
                count++;
            }
        }

        System.out.println(count);
    }
}