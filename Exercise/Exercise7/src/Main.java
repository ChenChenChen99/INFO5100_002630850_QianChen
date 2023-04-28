public class Main {
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i])) {
                System.out.println(array[i] + " is even");
            } else {
                System.out.println(array[i] + " is odd");
            }
        }

        exchange(array, 0, 8);
        System.out.print("The array after exchange: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int max = maximalInRange(array, 0, 8);
        System.out.println("The maximal number in the array is: " + max);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static void exchange(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int maximalInRange(int[] array, int start, int end) {
        int max = array[start];
        for (int i = start; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}