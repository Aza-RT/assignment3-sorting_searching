public class Sorter {
    public static int[] basicSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    static int[] combineArrays(int[] arr1, int[] arr2) {
        int length = arr1.length + arr2.length;
        int index1 = 0, index2 = 0;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            if (index1 == arr1.length) {
                arr[i] = arr2[index2];
                index2++;
            } else if (index2 == arr2.length) {
                arr[i] = arr1[index1];
                index1++;
            } else if (arr1[index1] < arr2[index2]) {
                arr[i] = arr1[index1];
                index1++;
            } else {
                arr[i] = arr2[index2];
                index2++;
            }
        }

        return arr;
    }

    public static int[] advancedSort(int[] array) {
        int length = array.length;

        if (length == 1) {
            return array;
        }

        int[] firstHalf = new int[(int)(length / 2) + length % 2];
        int[] secondHalf = new int[(int)(length / 2)];

        for (int i = 0; i < length; i++) {
            if (2 * i < length) {
                firstHalf[i] = array[i];
            } else {
                secondHalf[i % (int)(length / 2)] = array[i];
            }
        }

        return combineArrays(advancedSort(firstHalf), advancedSort(secondHalf));
    }

    public static void printArray(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
