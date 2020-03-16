import java.util.LinkedList;

public class Spiral {
    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        spiral.printSpiral(11, 12);
    }

    public void printSpiral(int height, int width) {

        int[][] massive = new int[height][width];

        int topCounter = 0;
        int bottomCounter = height - 1;
        int leftCounter = 0;
        int rightCounter = width - 1;

        int capacity = massive.length * massive[0].length;
        int current = 1;

        while (current <= capacity) {
            if (current <= capacity) {
                for (int i = leftCounter; i <= rightCounter; i++) {
                    massive[topCounter][i] = current;
                    current++;
                }
                topCounter++;
            }
            if (current <= capacity) {
                for (int i = topCounter; i <= bottomCounter; i++) {
                    massive[i][rightCounter] = current;
                    current++;
                }
                rightCounter--;
            }
            if (current <= capacity) {
                for (int i = rightCounter; i >= leftCounter; i--) {
                    massive[bottomCounter][i] = current;
                    current++;
                }
                bottomCounter--;
            }
            if (current <= capacity) {
                for (int i = bottomCounter; i >= topCounter; i--) {
                    massive[i][leftCounter] = current;
                    current++;
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
