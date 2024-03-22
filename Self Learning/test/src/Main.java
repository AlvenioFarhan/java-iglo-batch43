import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] X = new int[4][4];
        for (int index = 0; index < 4; index++) {
            for (int index2 = 0; index2 < 4; index2++) {
                X[index][index2] = scanner.nextInt();
            }
        }

        int countOdd = countOddNumbers(X);

        System.out.println(countOdd);

    }

    public static int countOddNumbers(int[][] X) {
        int count = 0;

        for (int index = 0; index < 4; index++) {
            for (int index2 = 0; index2 < 4; index2++) {
                if (X[index][index2] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
