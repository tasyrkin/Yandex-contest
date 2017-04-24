import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArithmeticProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());

        for (int k = 2; k <= n + 1; k++) {
            if(n % k != 0) {
                System.out.println(k);
                return;
            }
        }
    }
}
