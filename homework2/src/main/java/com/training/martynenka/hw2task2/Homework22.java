import java.util.Scanner;

/**
 * Class of homework №2 task 2.
 *
 * @version 1.0
 * @autor Aliaksei Martynenka
 */
class Homework22 {
    /**
     * Task Procedure
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter three integers separated by spaces:");
        System.out.println("1.Algorithm type\n\t1.Fibonacci numbers\n\t2.factorial calculation");
        System.out.println("2.Type of cycles\n\t1.while\n\t2.do-while\n\t3.for");
        System.out.println("3.Parameter passed to the algorithm");

        String[] inputData = in.nextLine().split(" ");
        try {
            int algoritmId = Integer.parseInt(inputData[0]);
            int loopType = Integer.parseInt(inputData[1]);
            int n = Integer.parseInt(inputData[2]);

            int factorial = 0;
            int[] fibonachiSeries = new int[0];

            // Числа Фибоначчи
            if (algoritmId == 1) {
                if (loopType == 1) {
                    fibonachiSeries = getFibonacciWhile(n);
                } else if (loopType == 2) {
                    fibonachiSeries = getFibonacciDoWhile(n);
                } else if (loopType == 3) {
                    fibonachiSeries = getFibonacciFor(n);
                }
                for (int i = 0; i < fibonachiSeries.length; i++) {
                    System.out.print(fibonachiSeries[i] + " ");
                }
            }
            // Факториал
            else if (algoritmId == 2) {
                if (loopType == 1) {
                    factorial = calculateFactorialWhile(n);
                } else if (loopType == 2) {
                    factorial = calculateFactorialDoWhile(n);
                } else if (loopType == 3) {
                    factorial = calculateFactorialFor(n);
                }
                System.out.print(factorial);
            }

        } catch (NumberFormatException e) {
            System.out.println("Failed to convert to number");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not enough values");
        } catch (NegativeArraySizeException e) {
            System.out.println("Negative value");
        }
    }

    /**
     * The function of obtaining an array of numbers of the Fibonacci series
     *
     * @param n - number of numbers in a row
     * @return returns an array of Fibonacci numbers using a loop While
     */
    private static int[] getFibonacciWhile(int n) {
        int[] fibonacciseries = new int[n];

        if (n > 1)
            fibonacciseries[1] = 1;
        int order = 2;
        while (order < n) {
            fibonacciseries[order] = fibonacciseries[order - 1] + fibonacciseries[order - 2];
            order++;
        }
        return fibonacciseries;
    }

    /**
     * The function of obtaining an array of numbers of the Fibonacci series
     *
     * @param n - number of numbers in a row
     * @return returns an array of Fibonacci numbers using a loop DoWhile
     */
    private static int[] getFibonacciDoWhile(int n) {
        int[] fibonacciseries = new int[n];

        if (n > 1)
            fibonacciseries[1] = 1;
        if (n > 2) {
            int order = 2;
            do {
                fibonacciseries[order] = fibonacciseries[order - 1] + fibonacciseries[order - 2];
                order++;
            } while (order < n);
        }
        return fibonacciseries;
    }

    /**
     * The function of obtaining an array of numbers of the Fibonacci series
     *
     * @param n - number of numbers in a row
     * @return returns an array of Fibonacci numbers using a loop For
     */
    private static int[] getFibonacciFor(int n) {
        int[] fibonacciseries = new int[n];

        if (n > 1)
            fibonacciseries[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacciseries[i] = fibonacciseries[i - 1] + fibonacciseries[i - 2];
        }
        return fibonacciseries;
    }

    /**
     * The function of obtaining the value of the factorial of a number
     *
     * @param n - the number from which we find the factorial
     * @return returns the factorial of a number using a loop While
     */
    private static int calculateFactorialWhile(int n) {
        int factorial = 1;
        while (n > 1) {
            factorial *= n;
            n--;
        }
        return factorial;
    }

    /**
     * The function of obtaining the value of the factorial of a number
     *
     * @param n - the number from which we find the factorial
     * @return returns the factorial of a number using a loop DoWhile
     */
    private static int calculateFactorialDoWhile(int n) {
        int factorial = 1;
        if (n > 1) {
            do {
                factorial *= n;
                n--;
            } while (n > 1);
        }
        return factorial;
    }

    /**
     * * The function of obtaining the value of the factorial of a number
     *
     * @param n - the number from which we find the factorial
     * @return returns the factorial of a number using a loop For
     */
    private static int calculateFactorialFor(int n) {
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}