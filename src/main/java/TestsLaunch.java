import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class TestsLaunch {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = in.nextInt();

        final int[] workingTime = new int[numTests];
        for (int test = 0; test < numTests; test++) {
            workingTime[test] = in.nextInt();
        }

        final HashMap<Integer, LinkedList<Integer>> testsTree = new HashMap<>();

        for (int test = 0; test < numTests; test++) {
            final int numDeps = in.nextInt();

            testsTree.put(test, new LinkedList<>());

            for (int dep = 0; dep < numDeps; dep++) {
                testsTree.get(test).add(in.nextInt() - 1);
            }
        }

        final long beforeChange = traverse(testsTree, 0, false, workingTime);
        final long afterChange = traverse(testsTree, 0, true, workingTime);

        System.out.println(beforeChange + " " + afterChange);

    }

    private static long traverse(final HashMap<Integer, LinkedList<Integer>> testsTree, final int currentTest, final boolean secondExec, final int[] workingTime) {

        final LinkedList<Integer> deps = testsTree.get(currentTest);

        if (deps == null) {
            return workingTime[currentTest];
        }
        long childWorkingTime = 0;
        for (Integer dep : deps) {
            childWorkingTime += traverse(testsTree, dep, secondExec, workingTime);
        }

        return workingTime[currentTest] + (secondExec ? 2 : 1) * childWorkingTime;


    }
}
