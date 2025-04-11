import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        int result = -1;

        for(int i = 0; i < input.length; i++){
            String[] temp = input[i].split("\\+");

            int tempSum = 0;
            for(int j = 0; j < temp.length; j++){
                tempSum += Integer.parseInt(temp[j]);
            }

            if(i == 0){
                result = tempSum;
            } else {
                result -= tempSum;
            }
        }

        System.out.println(result);;
    }
}