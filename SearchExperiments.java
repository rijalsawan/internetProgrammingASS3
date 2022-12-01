import java.util.Random;

public class SearchExperiments {
    public static void main(String[] args) {
        runExperiment();
    }
    public static int sequentialSearch(int[] array, int target){
        int iterations = 0;
        for (int j : array) {
            if (j == target) {
                iterations++;
            }
        }
        return iterations;
    }

    public static int binarySearch(int[] array, int target){
        //  instead of returning the index of the element that we were searching for, return the number of iterations of your algorithm it took to find that element.
        int iterations = 0;
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                iterations++;
                return iterations;
            } else if (array[mid] < target) {
                iterations++;
                low = mid + 1;
            } else {
                iterations++;
                high = mid - 1;
            }
        }
        return iterations;
    }
    public static int randomSearch(int[] array, int target){
        Random rand = new Random();
        int iterations = 0;
        while (true) {
            int index = rand.nextInt(array.length);
            if (array[index] == target) {
                iterations++;
                break;
            }
            iterations++;
        }
        return iterations;
    }

    public static void runExperiment(){
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int sequentialSum = 0;
        int binarySum = 0;
        int randomSum = 0;
        for (int i = 0; i < 1000; i++) {
            int target = (int) (Math.random() * 100) + 1;
            sequentialSum += sequentialSearch(array, target);
            binarySum += binarySearch(array, target);
            randomSum += randomSearch(array, target);
        }
        System.out.println("Sequential Search Average: " + sequentialSum / 1000);
        System.out.println("Binary Search Average: " + binarySum / 1000);
        System.out.println("Random Search Average: " + randomSum / 1000);
    }
}
