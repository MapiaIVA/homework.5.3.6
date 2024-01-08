import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите размерность массива: ");
        int n = scanner.nextInt();

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(1000);
            }
        }

        System.out.println("Массив:");
        printArray(array);

        long startTime = System.currentTimeMillis();

        int min = array[0][0];
        int max = array[0][0];
        boolean foundMinDuplicate = false;
        boolean foundMaxDuplicate = false;
        String minIndexes = "";
        String maxIndexes = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                    foundMinDuplicate = false;
                    minIndexes = i + ", " + j;
                } else if (array[i][j] == min) {
                    foundMinDuplicate = true;
                    minIndexes += " " + i + ", " + j;
                }

                if (array[i][j] > max) {
                    max = array[i][j];
                    foundMaxDuplicate = false;
                    maxIndexes = i + ", " + j;
                } else if (array[i][j] == max) {
                    foundMaxDuplicate = true;
                    maxIndexes += " " + i + ", " + j;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Наименьший элемент: " + min + " (индексы: " + minIndexes + ")");
        System.out.println("Наибольший элемент: " + max + " (индексы: " + maxIndexes);
        System.out.println("Время выполнения поиска: " + duration + " миллисекунд");
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}