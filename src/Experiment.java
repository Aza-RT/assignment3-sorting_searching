public class Experiment {
    static Sorter sorter = new Sorter();
    static Searcher searcher = new Searcher();

    public static long measureSortTime(int[] array, String type) {
        long start, end;

        start = System.nanoTime();
        if (type.equals("Basic")) {
            sorter.printArray(sorter.basicSort(array));
        }
        if (type.equals("Advanced")) {
            sorter.printArray(sorter.advancedSort(array));
        }
        end = System.nanoTime();

        return end - start;
    }

    public static long measureSearchTime(int[] array, int target, String type) {
        long start, end;
        int index = -1;

        start = System.nanoTime();
        if (type.equals("Linear")) {
            index = searcher.linearSearch(array, target);
        }
        if (type.equals("Binary")) {
            index = searcher.binarySearch(array, target);
        }
        end = System.nanoTime();

        if (index == -1) {
            System.out.println(target + " was not found in the array");
        } else {
            System.out.println(target + " is on the index " + index + " in the array");
        }

        return end - start;
    }
}
