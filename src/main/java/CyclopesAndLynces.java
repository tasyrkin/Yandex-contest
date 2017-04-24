import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CyclopesAndLynces {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();

        int[] dyoptries = new int[n];
        for (int i = 0; i < n; i++) {
            dyoptries[i] = in.nextInt();
        }

        Arrays.sort(dyoptries);

        int idx = 0;
        int pairs = 0;

        while (idx < n) {
            if (idx + 1 < n && dyoptries[idx + 1] - dyoptries[idx] <= 2) {
                idx += 2;
            } else {
                idx++;
            }
            pairs++;
        }

        System.out.println(pairs);

    }
}
