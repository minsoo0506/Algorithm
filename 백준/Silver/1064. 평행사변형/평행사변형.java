import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x_A = scan.nextDouble();
        double y_A = scan.nextDouble();
        double x_B = scan.nextDouble();
        double y_B = scan.nextDouble();
        double x_C = scan.nextDouble();
        double y_C = scan.nextDouble();

        if(!check(x_A, y_A, x_B, y_B, x_C, y_C)){
            System.out.println(-1.0);
            return;
        }
        else{
            double A_B = distance(x_A, y_A, x_B, y_B);
            double B_C = distance(x_B, y_B, x_C, y_C);
            double A_C = distance(x_A, y_A, x_C, y_C);

            double h1 = 2 * A_B + 2 * B_C;
            double h2 = 2 * B_C + 2 * A_C;
            double h3 = 2 * A_C + 2 * A_B;

            double min = Math.min(Math.min(h1, h2), h3);
            double max = Math.max(Math.max(h1, h2), h3);
            System.out.println(max - min);


        }
        scan.nextLine();
    }

    public static boolean check(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x2 - x1) * (y3 - y1) == (y2 - y1) * (x3 - x1) ? false : true;
    }

    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
    }
}