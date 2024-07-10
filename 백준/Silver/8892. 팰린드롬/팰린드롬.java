import java.io.*;

public class Main {
    public static boolean isPalindrome(String str){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
        }

        return true;
    }

    public static String checkPossibility(String[] strArr){
        for(int i = 0; i < strArr.length; i++){
            for(int j = 0; j < strArr.length; j++){
                if(i == j) continue;

                if(isPalindrome(strArr[i] + strArr[j])){
                    return strArr[i] + strArr[j];
                }
            }
        }

        return "0";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            String[] strArr = new String[k];

            for(int j = 0; j < k; j++){
                strArr[j] = br.readLine();
            }

            sb.append(checkPossibility(strArr)).append("\n");
        }

        System.out.println(sb);
    }
}