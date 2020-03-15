import java.util.LinkedList;

public class Spiral {
    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        spiral.printSpiral(7, 15);
    }

    public void printSpiral(int height, int width) {

        int[][] massive = new int[height][width];

        int topCounter = 0;
        int bottomCounter = height - 1;
        int leftCounter = 0;
        int rightCounter = width - 1;

        LinkedList<Integer> numbers = new LinkedList<>();
        int capacity = massive.length * massive[0].length;
        while (capacity > 0) {
            numbers.addFirst(capacity);
            capacity--;
        }

        while (!numbers.isEmpty()) {
            if (!numbers.isEmpty()) {
                for (int i = leftCounter; i <= rightCounter; i++) {
                    massive[topCounter][i] = numbers.pollFirst();
                }
                topCounter++;
            }
            if (!numbers.isEmpty()) {
                for (int i = topCounter; i <= bottomCounter; i++) {
                    massive[i][rightCounter] = numbers.pollFirst();
                }
                rightCounter--;
            }
            if (!numbers.isEmpty()) {
                for (int i = rightCounter; i >= leftCounter; i--) {
                    massive[bottomCounter][i] = numbers.pollFirst();
                }
                bottomCounter--;
            }
            if (!numbers.isEmpty()) {
                for (int i = bottomCounter; i >= topCounter; i--) {
                    massive[i][leftCounter] = numbers.pollFirst();
                }
                leftCounter++;
            }
        }

        printMassive(massive);

    }

    private void printMassive(int[][] ms) {
        for (int[] mm : ms ) {
            for (int num : mm) {
                System.out.print(num + "\t");
            }
            System.out.println("");
        }
    }
}
