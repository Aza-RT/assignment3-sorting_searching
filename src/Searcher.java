public class Searcher {
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, middle = 0;

        while (middle <= right) {
            middle = (int)((left + right) / 2);

            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }

        return -1;
    }
}
