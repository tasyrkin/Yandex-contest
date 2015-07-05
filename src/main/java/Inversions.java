import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inversions {
    public static void main(final String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long K = Integer.parseInt(br.readLine());

        long N = 1;
        while (N * (N - 1) / 2 < K) {
            N++;
        }

        System.out.println(N);

        StringBuilder sb = new StringBuilder();
        if (N * (N - 1) / 2 == K) {
            for (long i = N; i >= 1; i--) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(i);
            }

            System.out.println(sb.toString());

            return;
        }

        long prevVal = (N - 1) * (N - 2) / 2;

        long rem = K - prevVal;

        for (long i = N - 1, cnt = 1; i >= 1; i--, cnt++) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append(i);

            if (cnt == N - 1 - rem) {
                sb.append(" ");
                sb.append(N);
            }
        }

        System.out.println(sb.toString());

    }
}
