import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author  tasyrkin
 * @since   2014/05/25
 */
public class Drotik {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int[][] vals = new int[n][m];

        for (int i = 0; i < n; i++) {
            parts = br.readLine().split("\\s+");
            for (int j = 0; j < m; j++) {
                vals[i][j] = Integer.parseInt(parts[j]);
            }
        }

        long max = 0;
        int vai = -1;
        int vaj = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long curr = vals[i][j] * 8;
                for (int i1 = i - 1; i1 <= i + 1; i1++) {
                    for (int j1 = j - 1; j1 <= j + 1; j1++) {
                        if (i1 == i && j1 == j) {
                            continue;
                        }

                        if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < m) {
                            curr += vals[i1][j1];
                        }
                    }
                }

                // System.out.println(curr + ": " + (i + 1) + " " + (j + 1));

                if (curr > max) {
                    max = curr;
                    vai = i;
                    vaj = j;
                }
            }
        }

        System.out.println((vai + 1) + " " + (vaj + 1));

    }
}
