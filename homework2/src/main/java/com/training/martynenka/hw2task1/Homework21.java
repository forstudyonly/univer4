import static java.lang.Math.*;

/**
 * Class of homework №2 task 1.
 *
 * @version 1.0
 * @autor Aliaksei Martynenka
 */
public class Homework21 {
    /**
     * Task Procedure
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        int a;
        int p;
        double m1;
        double m2;
        double G;
        if (args.length == 4) {
            a = Integer.valueOf((args[0]));
            p = Integer.valueOf((args[1]));
            m1 = Double.valueOf((args[2]));
            m2 = Double.valueOf((args[3]));

            G = calculateG(a, p, m1, m2);
            System.out.println("G = " + G);
        } else {
            System.out.println("Not enough values");
        }
    }

    /**
     * The function of calculating the value of the number G
     *
     * @param a  - parameter a
     * @param p  - parameter р
     * @param m1 - parameter m1
     * @param m2 - parameter m2
     * @return returns the value of the number G
     */
    private static double calculateG(int a, int p, double m1, double m2) {
        return 4 * pow(PI, 2) * (pow(a, 3) / (pow(p, 2) * (m1 + m2)));
    }
}
