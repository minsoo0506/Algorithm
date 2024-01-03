import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            int R = scan.nextInt();
            char[] S = scan.nextLine().trim().toCharArray();
            String result = "";

            for(int j = 0; j < S.length; j++){
                for(int k = 0; k < R; k++){
                    result += S[j];
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
        scan.close();
    }
}