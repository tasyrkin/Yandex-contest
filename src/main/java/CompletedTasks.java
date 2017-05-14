import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CompletedTasks {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTasks = in.nextInt();

        final int[] positions = new int[numTasks + 1];

        for (int task = 1; task <= numTasks; task++) {
            positions[in.nextInt()] = task;
        }

        int result = 1;
        for (int task = 1; task <= numTasks; task++) {
            if (positions[task] < positions[task - 1]) result++;
        }

        System.out.println(result);

    }
}
