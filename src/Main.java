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

    public static void main(String[] args) {
        Experiment experiment = new Experiment();
        long time;

        System.out.println("---");
        for (int size: new int[]{10, 100, 100}) {
            int[] arr = generateRandomArray(size);

            for (String type: new String[]{"Basic", "Advanced"}) {
                time = experiment.measureSortTime(arr, type);
                System.out.println(type + " sort completed in " + time + " nanoseconds");
            }

            int randomElement = arr[random.nextInt(size)];
            System.out.println();

            for (String type: new String[]{"Linear", "Binary"}) {
                time = experiment.measureSearchTime(arr, randomElement, type);
                System.out.println(type + " search completed in " + time + " nanoseconds");
            }

            System.out.println("---");
        }
    }
}