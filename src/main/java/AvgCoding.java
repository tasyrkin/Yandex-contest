import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Incomplete solution
 */
public class AvgCoding {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numbers = in.nextInt();

        for(int i = 0; i < numbers; i++) {
            final long num = in.nextLong();

            for(int mult = 1; mult <= 100; mult++) {

                long currNum = num*mult;

                int bits = countBits(currNum);

                if(mult < bits) continue;

                final List<Long> result = new LinkedList<>();
                boolean carry = false;
                for(int currBit = 64; currBit >= 0; currBit--) {
                    if(((1L<<currBit) & currNum) == 1) {
                        if(mult > bits) {
                            bits++;
                            result.add((1L<<(currBit-1)));
                        } else {
                            if(carry) {
                                
                            }
                        }
                    }
                }

            }
        }

    }

    private static int countBits(final long num) {
        return 0;
    }
}
