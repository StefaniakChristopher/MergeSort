import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner arrayLengthAsker = new Scanner(System.in);
        System.out.println("\nInput the array length as a positive integer: ");
        System.out.print(">");
        int arrayLength = arrayLengthAsker.nextInt();
        arrayLengthAsker.close();
        int [] array = createRandomArray(arrayLength);
        long start_time = System.currentTimeMillis() / 1000;
        mergeSort(array, array[0], array[array.length - 1]);
        long time_spent = System.currentTimeMillis() / 1000 - start_time;
        System.out.println("Merge Sort: " + time_spent + "s");
        int [] otherArray = createRandomArray(arrayLength);
        start_time = System.currentTimeMillis() / 1000;
        bubbleSort(otherArray);
        time_spent = System.currentTimeMillis() / 1000 - start_time;
        System.out.println("Bubble Sort: " + time_spent + "s");

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubbleSort(int[] array) {
        for (int j = array.length - 1; j > 1; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    public static int [] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] a = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            a[i] = random.nextInt(0, 100);
        }
        return a;
    }

    public static void mergeSort(int [] a, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }

    /* public static int[] mergeA(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                k++;
                i++;
            } else {
                c[k] = b[j];
                k++;
                j++;
            }
        }

        while (i < a.length) {
            c[k] = a[i];
            k++;
            i++;
        }

        while (j < b.length) {
            c[k] = b[j];
            k++;
            j++;
        }
        return c;
    } */

    public static void mergeArray(int[] a, int start, int middle, int end) {
        int i = start;
        int j = middle;
        int[] tempArray = new int[end - start + 1];
        int k = 0;
        while (i < middle && j < end) {
            if (a[i] > a[j]) {
                tempArray[k] = a[j];
                j++;
                k++;
            } else {
                tempArray[k] = a[i];
                i++;
                k++;
            }
        }

        while (i < middle) {
            tempArray[k] = a[i];
            i++;
            k++;
        }

        while (j < end) {
            tempArray[k] = a[j];
            j++;
            k++;
        }

        for (i = start; i < end; i++) {
            a[i] = tempArray[i - start];
        }
    }
}
