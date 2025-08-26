import java.io.*;

public class Main {
    public static String target;
    public static String pattern;
    public static int[] failure;
    public static int count;
    public static StringBuilder resultIndexList;

    public static void makeFailure() {

        failure = new int[pattern.length()];

        int j = 0;
        for(int i = 1; i < failure.length; i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = failure[j - 1];
            }

            if(pattern.charAt(i) == pattern.charAt(j)){
                failure[i] = ++j;
            }
        }
    }

    public static void kmp() {

        count = 0;
        resultIndexList = new StringBuilder();

        int i = 0;
        int j = 0;

        while(i < target.length()) {
            if(target.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if(j == pattern.length()){
                    resultIndexList.append(i - j + 1).append("\n");

                    count++;
                    j = failure[j - 1];
                }
            }
            else if(j == 0) {
                i++;
            }
            else {
                j = failure[j - 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        target = br.readLine();
        pattern = br.readLine();
        makeFailure();
        kmp();

        if(resultIndexList.length() == 0) {
            bw.write(0 + "\n");
        }
        else {
            bw.write(count + "\n" + resultIndexList);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}