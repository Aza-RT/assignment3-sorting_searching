import java.util.Random;

public class Main {
    static Random random = new Random();

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(-10 * size, 10 * size);
        }

        return arr;
    }

    public static int[] generateRandomSortedArray(int size) {
        int[] arr = new int[size];
        arr[0] = random.nextInt(-10 * size, -9 * size);

        for (int i = 1; i < size; i++) {
            arr[i] = random.nextInt(arr[i - 1], arr[i - 1] + size);
        }

        return arr;
    }

    public static void main(String[] args) {
        Experiment experiment = new Experiment();
        long time;

        System.out.println("---");
        for (int size: new int[]{10, 100, 1000}) {
            int[] arr = generateRandomArray(size);

            for (String type: new String[]{"Basic", "Advanced"}) {
                time = experiment.measureSortTime(arr, type);
                System.out.println(type + " sort completed in " + time + " nanoseconds");
            }

            System.out.println();

            for (String type: new String[]{"Linear", "Binary"}) {
                if (type.equals("Linear")) {
                    int randomElement = arr[random.nextInt(0, size)];
                    time = experiment.measureSearchTime(arr, randomElement, type);
                    System.out.println(type + " search completed in " + time + " nanoseconds");
                } else {
                    arr = generateRandomSortedArray(size);
                    int randomElement = arr[random.nextInt(0, size)];
                    time = experiment.measureSearchTime(arr, randomElement, type);
                    System.out.println(type + " search completed in " + time + " nanoseconds");
                }
            }

            System.out.println("---");
        }

        for (int size: new int[]{10, 100, 1000}) {
            int[] arr = generateRandomSortedArray(size);

            for (String type: new String[]{"Basic", "Advanced"}) {
                time = experiment.measureSortTime(arr, type);
                System.out.println(type + " sort completed in " + time + " nanoseconds");
            }

            System.out.println();

            for (String type: new String[]{"Linear", "Binary"}) {
                int randomElement = arr[random.nextInt(0, size)];
                time = experiment.measureSearchTime(arr, randomElement, type);
                System.out.println(type + " search completed in " + time + " nanoseconds");
            }

            System.out.println("---");
        }
    }
}